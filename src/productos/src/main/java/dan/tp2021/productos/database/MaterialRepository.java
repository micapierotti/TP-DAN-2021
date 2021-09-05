package dan.tp2021.productos.database;

import dan.tp2021.productos.domain.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Integer> {

    Optional<Material> findByNombre(String name);
    List<Material> findByPrecio(Double precio);
}
