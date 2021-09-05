package dan.tp2021.productos.services.implementacion;

import dan.tp2021.productos.database.ProvisionRepository;
import dan.tp2021.productos.domain.DetalleProvision;
import dan.tp2021.productos.domain.Provision;
import dan.tp2021.productos.services.ProvisionService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProvisionServiceImpl implements ProvisionService {

    private ProvisionRepository provisionRepository;

    public ProvisionServiceImpl(ProvisionRepository provisionRepository) {
        this.provisionRepository = provisionRepository;
    }

    @Override
    public void crearProvision(List<DetalleProvision> listaProvisiones) {
        Provision provision = new Provision();

        provision.setFechaProvision(new Date());
        provision.setDetalle(listaProvisiones);

        provisionRepository.save(provision);
    }


}
