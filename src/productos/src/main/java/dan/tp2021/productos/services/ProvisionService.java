package dan.tp2021.productos.services;

import dan.tp2021.productos.domain.DetalleProvision;

import java.util.List;

public interface ProvisionService {
    void crearProvision(List<DetalleProvision> listaProvisiones);
}
