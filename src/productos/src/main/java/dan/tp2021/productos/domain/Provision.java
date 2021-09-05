package dan.tp2021.productos.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Provision {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date fechaProvision;
	@OneToMany(targetEntity = DetalleProvision.class, cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, orphanRemoval = true)
	private List<DetalleProvision> detalle;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFechaProvision() {
		return fechaProvision;
	}
	public void setFechaProvision(Date fechaProvision) {
		this.fechaProvision = fechaProvision;
	}
	public List<DetalleProvision> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<DetalleProvision> detalle) {
		this.detalle = detalle;
	}
	public Provision(Integer id, Date fechaProvision, List<DetalleProvision> detalle) {
		this.id = id;
		this.fechaProvision = fechaProvision;
		this.detalle = detalle;
	}
	public Provision() {
	}
}
