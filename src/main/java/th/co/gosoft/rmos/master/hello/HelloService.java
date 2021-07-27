package th.co.gosoft.rmos.master.hello;

public class HelloService {
    public Response getHello(String name) {
        return new Response(name);
    }
}
