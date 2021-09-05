package dan.tp2021.productos.database;

import dan.tp2021.productos.domain.DetalleProvision;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleProvisionRepository extends CrudRepository<DetalleProvision, Integer> {
}
