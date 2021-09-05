package dan.tp2021.productos.domain;
import java.util.Date;
import javax.persistence.*;

@Entity
public class MovimientoStock {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer idDetalleProvision;
	@OneToOne
	@JoinColumn(name = "MATERIAL_ID")
	private Material material;
	private Integer cantidadEntrada;
	private Integer cantidadSalida;
	private Date fecha;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDetalleProvision() {
		return idDetalleProvision;
	}
	public void setDetalleProvision(Integer idDetalleProvision) {
		this.idDetalleProvision = idDetalleProvision;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public Integer getCantidadEntrada() {
		return cantidadEntrada;
	}
	public void setCantidadEntrada(Integer cantidadEntrada) {
		this.cantidadEntrada = cantidadEntrada;
	}
	public Integer getCantidadSalida() {
		return cantidadSalida;
	}
	public void setCantidadSalida(Integer cantidadSalida) {
		this.cantidadSalida = cantidadSalida;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public MovimientoStock(Integer idDetalleProvision, Material material, Integer cantidadEntrada, Integer cantidadSalida, Date fecha) {
		this.idDetalleProvision = idDetalleProvision;
		this.material = material;
		this.cantidadEntrada = cantidadEntrada;
		this.cantidadSalida = cantidadSalida;
		this.fecha = fecha;
	}
	public MovimientoStock(Material material, Integer cantidadEntrada, Integer cantidadSalida, Date fecha) {
		this.idDetalleProvision = null;
		this.material = material;
		this.cantidadEntrada = cantidadEntrada;
		this.cantidadSalida = cantidadSalida;
		this.fecha = fecha;
	}
	public MovimientoStock() {
	}
}
