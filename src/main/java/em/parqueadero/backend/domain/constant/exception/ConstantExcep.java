package em.parqueadero.backend.domain.constant.exception;

public class ConstantExcep {

	private ConstantExcep() {
		throw new IllegalStateException("ConstantExcep class");
	}
	
	public static final String TIPO_VEHICULO_NO_EXISTE = "EL TIPO DE VEHICULO INGRESADO NO EXISTE";
	public static final String PARQUEAR_SOLO_DOMINGO_LUNES = "EL VEHICULO SOLO PUEDE PARQUEAR LOS DIAS DOMINGO Y LUNES";
}
