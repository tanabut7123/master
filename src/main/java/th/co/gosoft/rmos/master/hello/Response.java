package th.co.gosoft.rmos.master.hello;

import java.util.Objects;

public class Response {
    private String message;

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return age == response.age && message.equals(response.message) && Objects.equals(name, response.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, name, age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;

    public Response() {
    }

    public Response(String message) {
        setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
