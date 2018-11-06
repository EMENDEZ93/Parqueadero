package em.parqueadero.backend.domain.trm;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import em.parqueadero.backend.persistence.model.trm.TrmModel;
import em.parqueadero.trm.action.TCRMServicesInterface;
import em.parqueadero.trm.action.TCRMServicesInterfaceProxy;
import em.parqueadero.trm.action.TcrmResponse;

@Service
public class TrmServiceImpl implements TrmService {

	@Override
	public TrmModel getTrm() {

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
			trm.setValue(0.0f);

		}
		return trm;
	}

}
