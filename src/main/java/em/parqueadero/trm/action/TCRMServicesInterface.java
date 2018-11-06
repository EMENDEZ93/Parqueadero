package em.parqueadero.trm.action;

public interface TCRMServicesInterface extends java.rmi.Remote 
{
    public em.parqueadero.trm.action.TcrmResponse queryTCRM(java.util.Calendar tcrmQueryAssociatedDate) throws java.rmi.RemoteException;
}
