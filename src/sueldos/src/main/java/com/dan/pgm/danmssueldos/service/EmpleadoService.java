package com.dan.pgm.danmssueldos.service;

import com.dan.pgm.danmssueldos.dto.EmpleadoDTO;

import java.util.List;

public interface EmpleadoService {
    EmpleadoDTO getEmpleadoById(Integer empleadoId);
    List<EmpleadoDTO> getAllEmpleados();
}
