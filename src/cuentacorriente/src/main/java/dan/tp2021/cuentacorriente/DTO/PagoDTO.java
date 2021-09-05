package dan.tp2021.cuentacorriente.DTO;

import dan.tp2021.cuentacorriente.domain.Cliente;
import dan.tp2021.cuentacorriente.domain.MedioPago;

import java.time.Instant;


public class PagoDTO {
    private Integer idCliente;
    private MedioPago medio;

    public PagoDTO(Integer idCliente,  MedioPago medio) {
        this.idCliente = idCliente;
        this.medio = medio;
    }

    public PagoDTO() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }


    public MedioPago getMedio() {
        return medio;
    }

    public void setMedio(MedioPago medio) {
        this.medio = medio;
    }
}
