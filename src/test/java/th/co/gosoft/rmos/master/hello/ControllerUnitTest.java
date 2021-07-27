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
}