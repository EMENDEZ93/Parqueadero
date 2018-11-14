package em.parqueadero.backend.databuilder.model.parqueadero;

import java.time.LocalDateTime;

import em.parqueadero.backend.databuilder.model.vehiculo.VehiculoTestDataBuilder;
import em.parqueadero.backend.persistence.entity.parqueadero.RegistroVehiculoParqueaderoEntity;
import em.parqueadero.backend.persistence.entity.vehiculo.VehiculoEntity;

public class ParqueaderoTestDataBuilder {

	private static final int ID_PARQUEADERO = 1;
	private static final LocalDateTime FECHA_INGRESO = LocalDateTime.now();
	private static final VehiculoEntity VEHICULO_ENTITY = new VehiculoTestDataBuilder().buildEntity();
	private static final boolean PARQUEADERO = true;
	private static double COSTO = 5000;
	private static final LocalDateTime FECHA_SALIDA = LocalDateTime.now().plusHours(1);
	
	public RegistroVehiculoParqueaderoEntity buildEntity() {
		RegistroVehiculoParqueaderoEntity registroVehiculoParqueaderoEntity = new RegistroVehiculoParqueaderoEntity();
		registroVehiculoParqueaderoEntity.setIdParqueadero(ID_PARQUEADERO);
		registroVehiculoParqueaderoEntity.setFechaIngreso(FECHA_INGRESO);
		registroVehiculoParqueaderoEntity.setVehiculoEntity(VEHICULO_ENTITY);
		registroVehiculoParqueaderoEntity.setSeEncuentraParqueado(PARQUEADERO);
		registroVehiculoParqueaderoEntity.setCosto(COSTO);
		registroVehiculoParqueaderoEntity.setFechaSalida(FECHA_SALIDA);
		
		return registroVehiculoParqueaderoEntity;
	}
	
}
