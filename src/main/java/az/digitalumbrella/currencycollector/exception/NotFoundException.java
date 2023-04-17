package az.digitalumbrella.currencycollector.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Record was not found");
    }
}
