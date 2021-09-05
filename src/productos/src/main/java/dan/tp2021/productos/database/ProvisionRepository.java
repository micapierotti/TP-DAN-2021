package dan.tp2021.productos.database;

import dan.tp2021.productos.domain.Provision;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvisionRepository extends CrudRepository<Provision, Integer> {
}
