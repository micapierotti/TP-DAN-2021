package dan.tp2021.productos.services.implementacion;

import dan.tp2021.productos.database.MaterialRepository;
import dan.tp2021.productos.database.MovimientoStockRepository;
import dan.tp2021.productos.domain.*;
import dan.tp2021.productos.dto.DetallePedidoDTO;
import dan.tp2021.productos.services.MaterialService;
import dan.tp2021.productos.services.ProvisionService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService{

    private MaterialRepository materialRepository;
    private ProvisionService provisionService;
    private MovimientoStockRepository movimientoRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository, ProvisionService provisionService, MovimientoStockRepository movimientoRepository) {
        this.materialRepository = materialRepository;
        this.provisionService = provisionService;
        this.movimientoRepository = movimientoRepository;
    }

    private static final String REST_API_PEDIDO_URL = "http://localhost:9002/api/pedido/";
    private static final String GET_DETALLE_URL = "detalle/";

    @Override
    public Material crearMaterial(Material m) {
        this.materialRepository.save(m);
        return m;
    }

    @Override
    public boolean borrarMaterial(Integer id) {
        Material m = buscarPorId(id);

        if(m != null){
            m.setUnidad(null);
            materialRepository.delete(m);
            return !materialRepository.findById(id).isPresent();
        } else {
            return false;
        }
    }

    @Override
    public Material actualizarMaterial(Material mat, Integer id) {
        try {
            if (materialRepository.findById(id).isPresent())
                return materialRepository.save(mat);
            else
                throw new RuntimeException("Para actualizar un material ingrese un id existente");
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Material buscarPorNombre(String nombre) {
        try {
            if (materialRepository.findByNombre(nombre).isPresent())
                return materialRepository.findByNombre(nombre).get();
            else
                throw new RuntimeException("No se halló el material con nombre " + nombre);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean existeNombre(String nombre){
        try {
            return materialRepository.findByNombre(nombre).isPresent();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Material buscarPorId(Integer id) {
        try{
            if (materialRepository.findById(id).isPresent())
                return materialRepository.findById(id).get();
            else
                throw new RuntimeException("No se halló el material de id " + id);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Material> buscarPorRangoStock(Integer stockMin, Integer stockMax) {
        try{
            List<Material> materiales = (List<Material>) materialRepository.findAll();
            List<Material> materialesFiltrados = new ArrayList<Material>();

            materiales.stream().forEach((m) -> {
                if(m.getStockActual() >= stockMin && m.getStockActual() <= stockMax) {
                    materialesFiltrados.add(m);
                }
            });

            return materialesFiltrados;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Material> buscarPorPrecio(Double precio) {
        try{
            return materialRepository.findByPrecio(precio);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Material> buscarTodos() {
        try{
            return (List<Material>) materialRepository.findAll();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void registrarMovimientoStock(ArrayList<Integer> idsDetalles) {
        List<DetalleProvision> listaDetallesProvision = new ArrayList<>();

        for(Integer id : idsDetalles){
            String url = REST_API_PEDIDO_URL + GET_DETALLE_URL + id;
            WebClient client = WebClient.create(url);

            DetallePedidoDTO detalle= client.get()
                    .uri(url).accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(DetallePedidoDTO.class)
                    .block();

            Integer idProducto = detalle.getIdProducto();
            Integer cantidad = detalle.getCantidad();
            MovimientoStock newMovimiento;

            if(materialRepository.findById(idProducto).isPresent()){
                Material m = materialRepository.findById(idProducto).get();
                m.setStockActual(m.getStockActual()-cantidad);
                materialRepository.save(m);

                if(m.getStockMinimo() >= m.getStockActual()){
                    DetalleProvision newDetProv = new DetalleProvision();
                    newDetProv.setMaterial(m);
                    newDetProv.setCantidad(cantidad);
                    listaDetallesProvision.add(newDetProv);
                    newMovimiento = new MovimientoStock(newDetProv.getId(), m, 0, cantidad, new Date());
                }else{
                    newMovimiento = new MovimientoStock(m, 0, cantidad, new Date());
                }
                movimientoRepository.save(newMovimiento);
            }else{
                throw new RuntimeException("No existe el material de id "+idProducto);
            }
        }

        if(!(listaDetallesProvision.size() == 0))
            provisionService.crearProvision(listaDetallesProvision);
    }
}