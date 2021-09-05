package dan.tp2021.cuentacorriente.exception;

public class ConnectionFailException  extends Exception{
    public ConnectionFailException(){
        super("Ha ocurrido un error, disculpe");
    }
}
