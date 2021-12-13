package mx.com.hdi.model;

import io.swagger.annotations.ApiModelProperty;

public class Transaccion {
	@ApiModelProperty(notes = "Identificador del cliente", example = "\"1\"", position = 0)
	private String idCliente;
	@ApiModelProperty(notes = "Nombre del cliente", example = "\"1\"", position = 1)
	private String nombrecliente;
	@ApiModelProperty(notes = "Nombre del vendedor", example = "\"1\"", position = 2)
	private String nombreVendedor;
	@ApiModelProperty(notes = "Identificador de factura", example = "\"1\"", position = 3)
	private String idFactura;
	
	public Transaccion() {
		this.idCliente = "";
		this.nombrecliente = "";
		this.nombreVendedor = "";
		this.idFactura = "";
	}
	
	public Transaccion(String idCliente, String nombrecliente, String nombreVendedor, String idFactura) {
		this.idCliente = idCliente;
		this.nombrecliente = nombrecliente;
		this.nombreVendedor = nombreVendedor;
		this.idFactura = idFactura;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombrecliente() {
		return nombrecliente;
	}

	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public String getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	@Override
	public String toString() {
		return "Transaccion [idCliente=" + idCliente + ", nombrecliente=" + nombrecliente + ", nombreVendedor="
				+ nombreVendedor + ", idFactura=" + idFactura + "]";
	}
}