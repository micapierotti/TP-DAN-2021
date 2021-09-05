package dan.tp2021.cuentacorriente.database;

import dan.tp2021.cuentacorriente.domain.Pago;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends CrudRepository<Pago, Integer> {

    List<Pago> findPagoByIdCliente(Integer idCliente);
}
