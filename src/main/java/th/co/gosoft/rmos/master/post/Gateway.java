package th.co.gosoft.rmos.master.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Gateway {

    @Autowired
    private RestTemplate restTemplate;

    public List<Response> getPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        List<Response> responses = restTemplate.getForObject(url, List.class);
        return responses;
    }

    public Response getPostById(int id) {
        String url = "https://jsonplaceholder.typicode.com/posts/"+id;
        Response response = restTemplate.getForObject(url, Response.class);
        return response;
    }
}
