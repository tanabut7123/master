package th.co.gosoft.rmos.master.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Gateway {

    @Value("${POSTS_GATEWAY_URL:https://jsonplaceholder.typicode.com/posts}")
    private String url;


    @Autowired
    private RestTemplate restTemplate;

    public List<Response> getPosts() {
        List<Response> responses = restTemplate.getForObject(url, List.class);
        return responses;
    }

    public Response getPostById(int id) {
        Response response = restTemplate.getForObject(url+"/"+id, Response.class);
        return response;
    }
}
