package aquinones.technicaltest.techincaltest.exception;

public class BadRequestException extends Exception {
    private int statusCode;

    public BadRequestException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
