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

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void getHelloWithTanabutShouldBeReturnResponseWithTanabut() {
        Response response = testRestTemplate.getForObject("/hello/tanabut", Response.class);

        assertEquals("tanabut", response.getMessage());
        assertEquals(new Response("tanabut"), response);
    }

    @Test
    public void getHelloWithType1ShouldBeSizeOfResponseIs4() {
        customerRepository.deleteAll();
        customerRepository.save(new Customer("tanabut", "12"));
        customerRepository.save(new Customer("tanabut", "23"));
        customerRepository.save(new Customer("tanabut", "35"));
        customerRepository.save(new Customer("tanabut", "12"));
        Response[] responses = testRestTemplate.getForObject("/hello?type=1", Response[].class);

        assertEquals(4, responses.length);
    }

    @Test
    public void getHelloWithType2ShouldBeSizeOfResponseIs7() {
        customerRepository.deleteAll();
        customerRepository.save(new Customer("tanabut", "12"));
        customerRepository.save(new Customer("tanabut", "23"));
        customerRepository.save(new Customer("tanabut", "35"));
        customerRepository.save(new Customer("tanabut", "12"));
        customerRepository.save(new Customer("tanabut", "23"));
        customerRepository.save(new Customer("tanabut", "35"));
        customerRepository.save(new Customer("tanabut", "12"));
        Response[] responses = testRestTemplate.getForObject("/hello?type=2", Response[].class);

        assertEquals(7, responses.length);
    }

    @Test
    public void getHelloWithNotTypeShouldBeRestClientExceptionTypeCheckExceptionClass() {
        assertThrows(RestClientException.class, () -> {
            testRestTemplate.getForObject("/hello", Response[].class);
        });
    }

    @Test
    public void getHelloWithNotTypeShouldBeRestClientExceptionTypeCheckResponseEntity() {
        ResponseEntity<ErrorResponse> responseEntity = testRestTemplate.getForEntity("/hello", ErrorResponse.class);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("SYM00003", responseEntity.getBody().getErrorCode());
        assertTrue(responseEntity.getBody().getErrorMessage().contains("'type'"));
    }

    @Test
    public void postHelloWithCorrectHelloRequestShouldBeStatusCREATEDAndBodyIs1() {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setName("tanabut");
        helloRequest.setAge(40);

        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity("/hello", helloRequest, String.class);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("1", responseEntity.getBody());
    }

    @Test
    public void postHelloWithNotScopeAgeShouldBeBadRequest() {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setName("tanabut");
        helloRequest.setAge(17);

        ResponseEntity<ErrorResponse> responseEntity = testRestTemplate.postForEntity("/hello", helloRequest, ErrorResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("SYM00002", responseEntity.getBody().getErrorCode());
        assertTrue(responseEntity.getBody().getErrorMessage().contains("'age'"));
        assertTrue(responseEntity.getBody().getErrorMessage().contains("Min.age"));
    }

    @Test
    public void postHelloWithNotNameShouldBeBadRequest() {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setAge(30);

        ResponseEntity<ErrorResponse> responseEntity = testRestTemplate.postForEntity("/hello", helloRequest, ErrorResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("SYM00002", responseEntity.getBody().getErrorCode());
        assertTrue(responseEntity.getBody().getErrorMessage().contains("'name'"));
        assertTrue(responseEntity.getBody().getErrorMessage().contains("NotNull.name"));
    }
}