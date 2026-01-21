package exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super("Non Trovato");
    }
}
