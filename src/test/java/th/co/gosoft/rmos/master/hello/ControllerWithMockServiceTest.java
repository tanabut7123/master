package th.co.gosoft.rmos.master.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerWithMockServiceTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private HelloService helloService;

    @Test
    public void testWithMockHelloService() {
        given(helloService.getHello("tanabut")).willReturn(new Response("karan"));
        Response response = testRestTemplate.getForObject("/hello/tanabut", Response.class);

        assertEquals("karan", response.getMessage());
    }
}
