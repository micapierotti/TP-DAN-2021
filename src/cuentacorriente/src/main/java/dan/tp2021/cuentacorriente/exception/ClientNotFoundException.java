package dan.tp2021.cuentacorriente.exception;

public class ClientNotFoundException extends Exception{
    public ClientNotFoundException(Integer id) {
        super("El cliente con id: " + id + " no fue encontrado.");
    }
}
