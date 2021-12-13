package mx.com.hdi.service;

import java.util.List;

import mx.com.hdi.model.Articulo;
import mx.com.hdi.model.Transaccion;
import mx.com.hdi.model.response.GenericResponse;

public interface ISegurosService {
	public GenericResponse<List<Transaccion>> getTransacion();
	public GenericResponse<List<Articulo>> getArticulo();
}
