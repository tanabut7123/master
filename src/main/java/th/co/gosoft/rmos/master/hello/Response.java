package th.co.gosoft.rmos.master.hello;

public class Response {
    private String message;

    Response(String message) {
        setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}