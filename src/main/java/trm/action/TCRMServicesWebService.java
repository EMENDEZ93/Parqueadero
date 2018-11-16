package trm.action;

public interface TCRMServicesWebService extends javax.xml.rpc.Service
{
	public java.lang.String getTCRMServicesWebServicePortAddress();

	public trm.action.TCRMServicesInterface getTCRMServicesWebServicePort() throws javax.xml.rpc.ServiceException;

	public trm.action.TCRMServicesInterface getTCRMServicesWebServicePort( java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
