package mx.com.hdi.util;


public class Constants {

	//Respuestas generales
	public static final String RESULT_SUCCESS_DESCRIPTION	 = "Transacción exitosa.";
	public static final String RESULT_BAD_REQUEST 			 = "Lo sentimos, la solicitud no es válida, por favor verifíquela nuevamente.";
	public static final String RESULT_ERROR_DESCRIPTION 	 = "Se encontró un problema durante la transacción, inténtelo más tarde.";
	public static final String NOT_FOUND_DATA_REQUEST 		 = "Lo sentimos, no se encontro información, por favor verifíque nuevamente.";
	
	//TIPOS DE PARAMETROS
	public static final int CURSOR_TYPE 	= oracle.jdbc.OracleTypes.CURSOR;
		
	//funciones
	public static final String GET_TRANSACCION = "FNGET_TRANSACCION()";
	public static final String GET_ARTICULO = "FNGET_ARTICULO()";
}
