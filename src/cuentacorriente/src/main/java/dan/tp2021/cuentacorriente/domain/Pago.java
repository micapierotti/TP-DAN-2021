package dan.tp2021.cuentacorriente.domain;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
public class Pago {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer idCliente;
	private Date fechaPago;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "medioPago_id", referencedColumnName = "id")
	private MedioPago medio;


	public Pago(Integer idCliente, Date fechaPago, MedioPago medio) {
		this.idCliente = idCliente;
		this.fechaPago = fechaPago;
		this.medio = medio;
	}

	public Pago() {

	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCliente() {
		return this.idCliente;
	}
	public void setCliente(Integer cliente) {
		this.idCliente = cliente;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public MedioPago getMedio() {
		return medio;
	}
	public void setMedio(MedioPago medio) {
		this.medio = medio;
	}
	
	
}
