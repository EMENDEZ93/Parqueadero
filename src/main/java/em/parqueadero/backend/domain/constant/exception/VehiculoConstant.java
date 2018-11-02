package em.parqueadero.backend.domain.constant.exception;

public class VehiculoConstant {

	private VehiculoConstant() {
		throw new IllegalStateException("VehiculoConstant class");
	}
	
	public static final String MOTO = "Moto";
	public static final String CARRO = "Carro";
	public static final int LIMITE_CARROS_PARQUEADOS = 20;
	public static final int LIMITE_MOTOS_PARQUEADAS = 10;
	
	
}
