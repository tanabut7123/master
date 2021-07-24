package th.co.gosoft.rmos.master.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getHelloWithTanabutShouldBeReturnResponseWithTanabut() {
        Response response = testRestTemplate.getForObject("/hello/tanabut", Response.class);

        assertEquals("tanabut", response.getMessage());
    }
}