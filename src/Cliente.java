import java.rmi.*;
public class Cliente
{
    public Cliente()
    {

        System.out.println("Arrancando o Cliente...");
// Vamos tentar ir aceder ao Servidor de Registos para recolher a interface
        try
        {
            msi = (InterfaceServidorMat) Naming.lookup("rmi://127.0.0.1/ServidorMat_1");
        }
        catch (Exception e)
        {
            System.out.println("Falhou o arranque do Cliente.\n"+e);
            System.out.println("Certifique-se que tanto o Servidor de Registos como a Aplicação Servidora estão a correr correctamen");
                    System.exit(0);
        }
    }
    public double area(double a, double b) throws RemoteException
    {
        return msi.multiplica(a,b);
    }
    public double perimetro(double a, double b) throws RemoteException
    {
        double metade = msi.soma(a,b);
        return msi.multiplica(2.0,metade);
    }
    public static void main (String[] argv)
    {
        Cliente c = new Cliente();
        try
        {
            System.out.println("Area: " + c.area(20.0,40.0));
            System.out.println("Perimetro: " + c.perimetro(20.0,40.0));
        }
        catch (Exception e)
        {
            System.out.println("Excepção durante chamadas remotas:" +e);
        }
    }
    private InterfaceServidorMat msi; // A interface para o objecto remoto
}