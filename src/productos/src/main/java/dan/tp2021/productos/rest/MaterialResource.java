package dan.tp2021.productos.rest;

import dan.tp2021.productos.domain.Material;
import dan.tp2021.productos.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/productos")
@Api(value = "MaterialResource", description = "Permite gestionar los materiales")
public class MaterialResource {

    @Autowired
    MaterialService materialSrv;

    @PostMapping
    @ApiOperation(value = "Crear un material")
    public ResponseEntity<String> crear(@RequestBody Material nuevoMaterial){

        System.out.println("Crear material: "+ nuevoMaterial.toString());

        if(nuevoMaterial.getNombre()==null)
            return ResponseEntity.badRequest().body("El material debe tener un nombre especificado.");
        if(materialSrv.existeNombre(nuevoMaterial.getNombre()))
            return ResponseEntity.badRequest().body("Ya existe un material con ese nombre. Ingrese un nombre único.");
        if(nuevoMaterial.getPrecio()==null)
            return ResponseEntity.badRequest().body("El material debe tener precio especificado.");
        if(nuevoMaterial.getStockActual()==null || nuevoMaterial.getStockMinimo()==null)
            return ResponseEntity.badRequest().body("El material debe tener un stock actual y un stock mínimo.");

        materialSrv.crearMaterial(nuevoMaterial);
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Actualizar un material")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Actualizado correctamente"),
        @ApiResponse(code = 401, message = "No autorizado"),
        @ApiResponse(code = 403, message = "Prohibido"),
        @ApiResponse(code = 404, message = "El ID no existe")
    })
    public ResponseEntity<Material> actualizar(@RequestBody Material materialActualizado,  @PathVariable Integer id){
        return ResponseEntity.ok(materialSrv.actualizarMaterial(materialActualizado, id));
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Borrar un material según su id")
    public ResponseEntity<String> borrar(@PathVariable Integer id){

        boolean result = materialSrv.borrarMaterial(id);

        if(result)
            return ResponseEntity.ok("Se ha borrado exitosamente el material de id "+id);

        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Busca un material según su id")
    public ResponseEntity<Material> getMaterialById(@PathVariable Integer id){

        Material m = materialSrv.buscarPorId(id);

        if(m != null)
            return ResponseEntity.ok(m);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping
    @ApiOperation(value = "Devuelve todos los productos")
    public ResponseEntity<List<Material>> buscarTodos() {

        List<Material> materiales = materialSrv.buscarTodos();
        if(materiales.size()>0) return ResponseEntity.ok(materiales);

        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/get-by-price/{price}")
    @ApiOperation(value = "Devuelve todos los productos con el precio pedido")
    public ResponseEntity<List<Material>> getMaterialsByPrice(@PathVariable Double price) {

        List<Material> materiales = materialSrv.buscarPorPrecio(price);

        if(materiales.size()>0)
            return ResponseEntity.ok(materiales);
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/get-by-stock-range")
    @ApiOperation(value = "Devuelve todos los productos según el rango de stock")
    public ResponseEntity<List<Material>> getMaterialsByStockRange(@RequestParam(required = false) Integer minStock, @RequestParam(required = false) Integer maxStock) {

        if(minStock==null) minStock = 0;
        if(maxStock==null) maxStock = 100000000;
        List<Material> materiales = materialSrv.buscarPorRangoStock(minStock, maxStock);

        if(materiales.size()>0)
            return ResponseEntity.ok(materiales);
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/get-by-name")
    @ApiOperation(value = "Devuelve un producto según el nombre")
    public ResponseEntity<Material> getMaterialByName(@RequestParam String nombre) {

        Material material = materialSrv.buscarPorNombre(nombre);

        if(material != null)
            return ResponseEntity.ok(material);
        return ResponseEntity.notFound().build();
    }
}
