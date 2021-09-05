package dan.tp2021.cuentacorriente.DTO;

import dan.tp2021.cuentacorriente.domain.Pago;

import java.util.List;

public class EstadoClienteDTO {
    private List<PedidoDTO> facturas;
    private List<Pago> pagos;

    public EstadoClienteDTO(List<PedidoDTO> facturas, List<Pago> pagos) {
        this.facturas = facturas;
        this.pagos = pagos;
    }

    public EstadoClienteDTO(){};

    public List<PedidoDTO> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<PedidoDTO> facturas) {
        this.facturas = facturas;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }
}
