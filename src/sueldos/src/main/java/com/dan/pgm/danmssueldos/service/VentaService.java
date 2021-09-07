package com.dan.pgm.danmssueldos.service;

import com.dan.pgm.danmssueldos.dto.EmpleadoDTO;
import com.dan.pgm.danmssueldos.dto.PedidoDTO;
import com.dan.pgm.danmssueldos.dto.VentaDTO;
import com.dan.pgm.danmssueldos.model.Venta;

import java.util.List;

public interface VentaService {

    VentaDTO crearVenta(PedidoDTO pedidoDTO, Integer empleadoId);
    List<Venta> obtenerVentas();
    List<Venta> obtenerVentasByEmpleado(Integer empleadoId);
    List<Venta> obtenerVentasDelMes();
    Long cantVentasDelMesByEmpleado(Integer empleadoId);
    EmpleadoDTO mejorVendedorDelMes();

}
