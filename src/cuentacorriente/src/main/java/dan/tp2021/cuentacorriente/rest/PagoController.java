package dan.tp2021.cuentacorriente.rest;

import dan.tp2021.cuentacorriente.DTO.PagoDTO;
import dan.tp2021.cuentacorriente.domain.Pago;
import dan.tp2021.cuentacorriente.exception.ConnectionFailException;
import dan.tp2021.cuentacorriente.service.PagoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/cuenta")
@RestController
public class PagoController {

    private PagoService pagoService;

    public PagoController(PagoService pago){
        this.pagoService = pago;
    }

    @PostMapping("/pago")
    public ResponseEntity<?> realizarPago(@RequestBody PagoDTO pago){

        if(pagoService.realizarPago(pago) != null){
            return new ResponseEntity<>("Pago Realizado Correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/estado/{clienteId}")
    public ResponseEntity<?> getEstadoCliente(@PathVariable Integer clienteId) throws ConnectionFailException {

        if(pagoService.estado(clienteId) != null){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
