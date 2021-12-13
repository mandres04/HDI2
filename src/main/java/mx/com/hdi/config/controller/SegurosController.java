package mx.com.hdi.config.controller;

import static mx.com.hdi.util.Constants.RESULT_BAD_REQUEST;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.com.hdi.model.Articulo;
import mx.com.hdi.model.Transaccion;
import mx.com.hdi.model.response.GenericResponse;
import mx.com.hdi.service.ISegurosService;

@CrossOrigin(origins = "*" , methods = {RequestMethod.POST , RequestMethod.GET})
@Api(value = "Grid web")
@RestController
@RequestMapping("/")
public class SegurosController {

	private static final Logger LOG = LoggerFactory.getLogger(SegurosController.class);
	
	@Autowired
	private ISegurosService segurosService;
	
	@ApiOperation(value = "Permite consultar grid1")
	@PostMapping("/grid1")
	public ResponseEntity<GenericResponse<List<Transaccion>>> reactiveForm(HttpServletRequest request) {
		long tini = System.currentTimeMillis();
		GenericResponse<List<Transaccion>> response = new GenericResponse<>();
		try {
			response = segurosService.getTransacion();
		} catch (Exception e) {
			response = new GenericResponse<>(HttpStatus.BAD_REQUEST.value(), RESULT_BAD_REQUEST);
		}
		return ResponseEntity.status(response.getCode()).body(response);
	}
	
	@ApiOperation(value = "Permite consultar grid2")
	@PostMapping("/grid2")
	public ResponseEntity<GenericResponse<List<Articulo>>> reactiveModule(HttpServletRequest request) {
		long tini = System.currentTimeMillis();
		GenericResponse<List<Articulo>> response = new GenericResponse<>();
		try {
			response = segurosService.getArticulo();
		} catch (Exception e) {
			response = new GenericResponse<>(HttpStatus.BAD_REQUEST.value(), RESULT_BAD_REQUEST);
		}
		return ResponseEntity.status(response.getCode()).body(response);
	}
	
}
