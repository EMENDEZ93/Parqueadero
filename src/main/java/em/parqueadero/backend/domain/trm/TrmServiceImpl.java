package em.parqueadero.backend.domain.trm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.dto.trm.TrmDto;
import em.parqueadero.backend.domain.exception.preconditionexception.TrmException;
import em.parqueadero.trm.action.TCRMServicesInterface;
import em.parqueadero.trm.action.TCRMServicesInterfaceProxy;
import em.parqueadero.trm.action.TcrmResponse;

@Service
public class TrmServiceImpl implements TrmService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TrmServiceImpl.class);

	@Override
	public TrmDto getTrm() throws TrmException {

		TrmDto trm = new TrmDto();

		try {

			TCRMServicesInterface proxy = new TCRMServicesInterfaceProxy(
					"https://www.superfinanciera.gov.co/SuperfinancieraWebServiceTRM/TCRMServicesWebService/TCRMServicesWebService?WSDL");
			TcrmResponse tcrmResponse;
			tcrmResponse = proxy.queryTCRM(null);
			if (tcrmResponse != null) {
				trm.setValue(tcrmResponse.getValue());
				return trm;
			}
		} catch (Exception e) {
			LOGGER.info("Error en /trm", e);
			throw new TrmException(ConstantExcep.FALLO_SERVICIO_TRM);
		} 
		
		trm.setValue(0.0f);
		return trm;
	}

}
