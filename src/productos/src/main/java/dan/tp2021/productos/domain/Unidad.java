package dan.tp2021.productos.domain;
import javax.persistence.*;

@Entity
public class Unidad {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descripcion;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Unidad() {
	}

	public Unidad(Integer id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
}
