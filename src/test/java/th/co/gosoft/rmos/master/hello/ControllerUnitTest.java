package th.co.gosoft.rmos.master.hello;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerUnitTest {
    @Test
    public void getHelloWithStubService() {
        Controller controller = new Controller();
        controller.setHelloService(new HelloService());
        assertEquals("tanabut", controller.get("tanabut").getMessage());
    }

    @Test
    public void getHelloWithPropertyInjectionKaranService() {
        Controller controller = new Controller();
        controller.setHelloService(new KaranService());
        assertEquals("Karan", controller.get("tanabut").getMessage());
    }

    @Test
    public void getHelloWithContructorInjectionKaranService() {
        Controller controller = new Controller(new KaranService());
        assertEquals("Karan", controller.get("tanabut").getMessage());
    }

    @Test
    public void getHelloWithMethodInjectionKaranService() {
        Controller controller = new Controller();
        assertEquals("Karan", controller.get(new KaranService(), "tanabut").getMessage());
    }
}

class KaranService extends HelloService {
    @Override
    public Response getHello(String name) {
        return new Response("Karan");
    }
}