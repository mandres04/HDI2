package mx.com.hdi.dao;

import static mx.com.hdi.util.Constants.CURSOR_TYPE;
import static mx.com.hdi.util.Constants.GET_ARTICULO;
import static mx.com.hdi.util.Constants.GET_TRANSACCION;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.com.hdi.model.Transaccion;
import mx.com.hdi.model.Articulo;
import oracle.jdbc.OracleConnection;

@Repository
public class CatalogoDAO {
	
private static final Logger LOG = LoggerFactory.getLogger(CatalogoDAO.class);

	@Value("${schema.bd}")
	private String schema;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Transaccion> getTransacion() {
		long tini = System.currentTimeMillis();
		try {
			LOG.info("Se ejecuta FUNTION {}",GET_ARTICULO);
			return jdbcTemplate.execute((CallableStatementCreator) con ->{
				con = con.unwrap(OracleConnection.class);
				CallableStatement cs = con.prepareCall(schema+GET_ARTICULO);
				cs.registerOutParameter(1, CURSOR_TYPE);
				return cs;
			},(CallableStatementCallback<List<Transaccion>>) cs -> {
				cs.execute();
				ResultSet rs = (ResultSet) cs.getObject(1);
				List<Transaccion> response = new ArrayList<>();
				while (rs.next()) {	
//					LOG.info("----> {}, {}",rs.getString(1), rs.getString(2));
					response.add(new Transaccion(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
				}
				LOG.info("consulta exitosa {}, tiempo {}", response, tini);
				return response;
			});
		} catch (Exception e) {
			LOG.info(e.getMessage());
			return null;
		}
	}
	
	public List<Articulo> getArticulo() {
		long tini = System.currentTimeMillis();
		try {
			LOG.info("Se ejecuta FUNTION {}",GET_TRANSACCION);
			return jdbcTemplate.execute((CallableStatementCreator) con ->{
				con = con.unwrap(OracleConnection.class);
				CallableStatement cs = con.prepareCall(schema+GET_TRANSACCION);
				cs.registerOutParameter(1, CURSOR_TYPE);
				return cs;
			},(CallableStatementCallback<List<Articulo>>) cs -> {
				cs.execute();
				ResultSet rs = (ResultSet) cs.getObject(1);
				List<Articulo> response = new ArrayList<>();
				while (rs.next()) {				
					response.add(new Articulo(rs.getString(1), rs.getString(2)));
				}
				LOG.info("consulta exitosa {}, tiempo {}", response, tini);
				return response;
			});
		} catch (Exception e) {
			LOG.info(e.getMessage());
			return null;
		}
	}
	
}