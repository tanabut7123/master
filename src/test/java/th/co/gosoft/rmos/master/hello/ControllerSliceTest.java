package th.co.gosoft.rmos.master.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(Controller.class)
public class ControllerSliceTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getHelloWithTanabutShouldBeReturnResponseWithTanabut() throws Exception {
        given(helloService.getHello("tanabut")).willReturn(new Response("karan"));

        MockHttpServletResponse mockHttpServletResponse = mockMvc.perform(get("/hello/tanabut")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

        // อันนี้ไปลองเคสเปลี่ยน Object คนละ Type
        assertEquals("karan", objectMapper.readValue(mockHttpServletResponse.getContentAsString(), Response.class).getMessage());
    }
}
