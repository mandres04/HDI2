package mx.com.hdi.model;

import io.swagger.annotations.ApiModelProperty;

public class Articulo {
	@ApiModelProperty(notes = "Identificador del articulo", example = "\"1\"", position = 0)
	private String idArticulo;
	@ApiModelProperty(notes = "Descripcion del articulo", example = "\"1\"", position = 1)
	private String descripcionArticulo;
	
	public Articulo() {
		this.idArticulo = "";
		this.descripcionArticulo = "";
	}
	public Articulo(String idArticulo, String descripcionArticulo) {
		this.idArticulo = idArticulo;
		this.descripcionArticulo = descripcionArticulo;
	}
	public String getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}
	
	@Override
	public String toString() {
		return "Articulo [idArticulo=" + idArticulo + ", descripcionArticulo=" + descripcionArticulo + "]";
	}
}