package trm.action;

public interface TCRMServicesInterface extends java.rmi.Remote 
{
    public trm.action.TcrmResponse queryTCRM(java.util.Calendar tcrmQueryAssociatedDate) throws java.rmi.RemoteException;
}
