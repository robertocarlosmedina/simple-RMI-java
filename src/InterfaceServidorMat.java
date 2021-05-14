import java.rmi.*;

public interface InterfaceServidorMat extends Remote {
    public double soma(double a, double b) throws RemoteException;
    public double subtrai(double a, double b) throws RemoteException;
    public double multiplica(double a, double b) throws RemoteException;
    public double divide(double a, double b) throws RemoteException;
}
