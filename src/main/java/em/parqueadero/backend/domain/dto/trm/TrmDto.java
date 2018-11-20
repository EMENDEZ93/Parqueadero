package em.parqueadero.backend.domain.dto.trm;

import java.io.Serializable;

public class TrmDto implements Serializable {
	
	private static final long serialVersionUID = 4795754599345805064L;
	
	private float value;

	public float getValue() { 
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
}
