package com.dan.pgm.danmssueldos.rest;

import com.dan.pgm.danmssueldos.service.SueldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sueldo")
public class SueldoController {

    @Autowired
    SueldoService sueldoService;

    @GetMapping("/liquidarSueldoByEmpleadoId/{empleadoId}")
    public ResponseEntity<?> liquidarSueldoByEmpleadoId(@PathVariable Integer empleadoId){

        return new ResponseEntity<>(sueldoService.liquidarSueldoByEmpleadoId(empleadoId), HttpStatus.OK);
    }

    @GetMapping("/liquidarSueldoEmpleados")
    public ResponseEntity<?> liquidarSueldosAllEmpleados(){

        return new ResponseEntity<>(sueldoService.liquidarSueldosEmpleados(), HttpStatus.OK);
    }

}
