package em.parqueadero.backend.domain.constant.exception;

public final class ConstantExcep {

	private ConstantExcep() {
		throw new IllegalStateException("ConstantExcep class");
	}
	
	public static final String TIPO_VEHICULO_NO_EXISTE = "EL TIPO DE VEHICULO INGRESADO NO EXISTE";
	public static final String PARQUEAR_SOLO_DOMINGO_LUNES = "EL VEHICULO SOLO PUEDE PARQUEAR LOS DIAS DOMINGO Y LUNES";
	public static final String NO_HAY_LUGAR_DISPONIBLE_MOTO = "NO HAY LUGAR DISPONIBLE PARA MOTOS";
	public static final String NO_HAY_LUGAR_DISPONIBLE_CARRO = "NO HAY LUGAR DISPONIBLE PARA CARROS";
	public static final String DATOS_NO_VALIDOS = "RECUERDE LLENAR LOS CAMPOS REQUERIDOS";
	public static final String PLACA_NO_VALIDA = "LA PLACA ES UN CAMPO REQUERIDO";
	public static final String TIPO_VEHICULO_NO_VALIDO = "EL TIPO DE VEHICULO ES UN CAMPO REQUERIDO";
	public static final String CILINDRAJE_NO_VALIDO = "EL CILINDRAJE ES UN CAMPO REQUERIDO";
	public static final String VEHICULO_PARQUEADO_CON_ESTAS_PLACAS = "EXISTE UN VEHICULO PARQUEADO CON ESTA PLACA ";
	public static final String FALLO_SERVICIO_TRM = "SERVICIO TRM ACTUALMENTE NO SE ENCUENTRA DISPONIBLE";
	
}
