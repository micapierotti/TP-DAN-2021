package dan.tp2021.productos.database;

import dan.tp2021.productos.domain.MovimientoStock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoStockRepository extends CrudRepository<MovimientoStock, Integer> {
}
