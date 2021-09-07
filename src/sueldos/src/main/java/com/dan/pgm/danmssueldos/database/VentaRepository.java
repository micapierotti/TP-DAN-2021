package com.dan.pgm.danmssueldos.database;

import com.dan.pgm.danmssueldos.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Integer> {

    List<Venta> findAll();
    List<Venta> findAllByEmpleado(Integer empleado);
    List<Venta> findAllByFechaVentaAfter(LocalDate fechaInicioMes);
}
