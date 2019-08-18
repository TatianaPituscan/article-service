package ro.creativewool.articleservice.exception;

public class BadRequestException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Bad Request";
    }
}
