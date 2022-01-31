package vehiclerental;

public class UserNameIsAlreadyTakenException extends RuntimeException{
    private String name;

    public UserNameIsAlreadyTakenException(String name) {
        this.name = name;
    }

    public UserNameIsAlreadyTakenException(String message, String name) {
        super(message);
        this.name = name;
    }

    public UserNameIsAlreadyTakenException(String message, Throwable cause, String name) {
        super(message, cause);
        this.name = name;
    }
}
