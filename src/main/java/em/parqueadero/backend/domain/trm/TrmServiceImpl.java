package em.parqueadero.backend.domain.trm;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import em.parqueadero.backend.domain.constant.exception.ConstantExcep;
import em.parqueadero.backend.domain.exception.preconditionexception.PreconditionException;
import em.parqueadero.backend.persistence.model.trm.TrmModel;
import em.parqueadero.trm.action.TCRMServicesInterface;
import em.parqueadero.trm.action.TCRMServicesInterfaceProxy;
import em.parqueadero.trm.action.TcrmResponse;

@Service
public class TrmServiceImpl implements TrmService {

	@Override
	public TrmModel getTrm() throws PreconditionException {

		TrmModel trm = new TrmModel();

		TCRMServicesInterface proxy = new TCRMServicesInterfaceProxy(
				"https://www.superfinanciera.gov.co/SuperfinancieraWebServiceTRM/TCRMServicesWebService/TCRMServicesWebService?WSDL");
		TcrmResponse tcrmResponse;
		try {
			tcrmResponse = proxy.queryTCRM(null);
			if (tcrmResponse != null) {
				trm.setValue(tcrmResponse.getValue());
				return trm;
			}
		} catch (RemoteException e) {

			throw new PreconditionException(ConstantExcep.FALLO_SERVICIO_TRM);
		}
		trm.setValue(0.0f);
		return trm;
	}

}
