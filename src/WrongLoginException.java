public class WrongLoginException extends RuntimeException {

    public WrongLoginException() {
        super("Error, Invalid login!!!");
    }
}
