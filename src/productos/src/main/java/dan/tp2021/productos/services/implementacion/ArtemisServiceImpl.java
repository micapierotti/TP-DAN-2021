package dan.tp2021.productos.services.implementacion;

import dan.tp2021.productos.services.ArtemisService;
import dan.tp2021.productos.services.MaterialService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArtemisServiceImpl implements ArtemisService {

    private MaterialService materialService;

    public ArtemisServiceImpl(MaterialService materialService) {
        this.materialService = materialService;
    }

    @JmsListener(destination = "COLA_PEDIDOS")
    public void recibirMensaje(ArrayList<Integer> idsDetalles){
        materialService.registrarMovimientoStock(idsDetalles);
    }
}
