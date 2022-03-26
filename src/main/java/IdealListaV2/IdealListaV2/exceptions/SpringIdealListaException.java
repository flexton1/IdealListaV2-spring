package IdealListaV2.IdealListaV2.exceptions;

public class SpringIdealListaException extends RuntimeException {
    public SpringIdealListaException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringIdealListaException(String exMessage) {
        super(exMessage);
    }
}
