package dan.tp2021.cuentacorriente.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({

		@JsonSubTypes.Type(value = Efectivo.class, name = "efectivo"),
		@JsonSubTypes.Type(value = Transferencia.class, name = "transferencia"),
		@JsonSubTypes.Type(value = Cheque.class, name = "cheque")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_pago",
		discriminatorType = DiscriminatorType.STRING)
public abstract class MedioPago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String observacion;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public MedioPago() {
	}

	public MedioPago(Integer id, String observacion) {
		this.id = id;
		this.observacion = observacion;
	}
}
