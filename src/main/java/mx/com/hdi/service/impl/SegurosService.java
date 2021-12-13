package mx.com.hdi.service.impl;

import static mx.com.hdi.util.Constants.RESULT_ERROR_DESCRIPTION;
import static mx.com.hdi.util.Constants.RESULT_SUCCESS_DESCRIPTION;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import mx.com.hdi.dao.CatalogoDAO;
import mx.com.hdi.model.Articulo;
import mx.com.hdi.model.Transaccion;
import mx.com.hdi.model.response.GenericResponse;
import mx.com.hdi.util.Utils;
import mx.com.hdi.service.ISegurosService;
import mx.com.hdi.service.impl.SegurosService;

@Service
public class SegurosService implements ISegurosService{

	private static final Logger LOG = LoggerFactory.getLogger(SegurosService.class);
	
	@Autowired
	private CatalogoDAO catalogoDAO;
	
	
	@Override
	public GenericResponse<List<Transaccion>> getTransacion(){
		long tini = System.currentTimeMillis();
		GenericResponse<List<Transaccion>> response = new GenericResponse<>();
		try {
			List<Transaccion> tx = catalogoDAO.getTransacion();
			response = new GenericResponse<>(HttpStatus.OK.value(), RESULT_SUCCESS_DESCRIPTION, tx);
		} catch (Exception e) {
			LOG.info("entro al metodo {}, tiempo de ejecucion {}",Thread.currentThread().getStackTrace()[1].getMethodName(), Utils.serviceTime(tini));
			response = new GenericResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), RESULT_ERROR_DESCRIPTION);
		}
		return response;
	}
	
	@Override
	public GenericResponse<List<Articulo>> getArticulo(){
		long tini = System.currentTimeMillis();
		GenericResponse<List<Articulo>> response = new GenericResponse<>();
		try {
			List<Articulo> art = catalogoDAO.getArticulo();
			response = new GenericResponse<>(HttpStatus.OK.value(), RESULT_SUCCESS_DESCRIPTION, art);
		} catch (Exception e) {
			LOG.info("entro al metodo {}, tiempo de ejecucion {}",Thread.currentThread().getStackTrace()[1].getMethodName(), Utils.serviceTime(tini));
			response = new GenericResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), RESULT_ERROR_DESCRIPTION);
		}
		return response;
	}
	
}
