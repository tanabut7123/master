package th.co.gosoft.rmos.master.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

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

    @Test
    public void getHelloWithType1ShouldBeSizeOfResponseIs4() {
        Response[] responses = testRestTemplate.getForObject("/hello?type=1", Response[].class);

        assertEquals(4, responses.length);
    }

    @Test
    public void getHelloWithType2ShouldBeSizeOfResponseIs7() {
        Response[] responses = testRestTemplate.getForObject("/hello?type=2", Response[].class);

        assertEquals(7, responses.length);
    }

    @Test
    public void getHelloWithNotTypeShouldBeRestClientException() {
        ResponseEntity<ErrorResponse> responseEntity = testRestTemplate.getForEntity("/hello", ErrorResponse.class);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("SYM00003", responseEntity.getBody().getErrorCode());
        assertTrue(responseEntity.getBody().getErrorMessage().contains("'type'"));

       /* assertThrows(RestClientException.class, () -> {
            testRestTemplate.getForObject("/hello", Response[].class);
        });*/
    }
}