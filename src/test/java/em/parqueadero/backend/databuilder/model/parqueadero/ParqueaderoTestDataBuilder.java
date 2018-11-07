package em.parqueadero.backend.databuilder.model.parqueadero;

import java.time.LocalDateTime;

import em.parqueadero.backend.databuilder.model.vehiculo.VehiculoTestDataBuilder;
import em.parqueadero.backend.persistence.entity.parqueadero.ParqueaderoEntity;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;

public class ParqueaderoTestDataBuilder {

	private static final int ID_PARQUEADERO = 1;
	private static final LocalDateTime FECHA_INGRESO = LocalDateTime.now();
	private static final VehiculoEntity VEHICULO_ENTITY = new VehiculoTestDataBuilder().buildEntity();
	private static final boolean PARQUEADERO = true;
	private static double COSTO = 5000;
	private static final LocalDateTime FECHA_SALIDA = LocalDateTime.now().plusHours(1);
	
	public ParqueaderoEntity buildEntity() {
		ParqueaderoEntity parqueaderoEntity = new ParqueaderoEntity();
		parqueaderoEntity.setIdParqueadero(ID_PARQUEADERO);
		parqueaderoEntity.setFechaIngreso(FECHA_INGRESO);
		parqueaderoEntity.setVehiculoEntity(VEHICULO_ENTITY);
		parqueaderoEntity.setParqueado(PARQUEADERO);
		parqueaderoEntity.setCosto(COSTO);
		parqueaderoEntity.setFechaSalida(FECHA_SALIDA);
		
		return parqueaderoEntity;
	}
	
}
