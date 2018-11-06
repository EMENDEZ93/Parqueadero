package em.parqueadero.trm.action;

public interface TCRMServicesWebService extends javax.xml.rpc.Service
{
	public java.lang.String getTCRMServicesWebServicePortAddress();

	public em.parqueadero.trm.action.TCRMServicesInterface getTCRMServicesWebServicePort() throws javax.xml.rpc.ServiceException;

	public em.parqueadero.trm.action.TCRMServicesInterface getTCRMServicesWebServicePort( java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
