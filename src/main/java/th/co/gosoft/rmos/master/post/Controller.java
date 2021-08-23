package th.co.gosoft.rmos.master.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController(value="postController")
public class Controller {

    @Autowired
    private Gateway gateway;

    @GetMapping(path="/posts")
    public List<Response> get() {
        List<Response> posts = gateway.getPosts();
        return posts;
    }

    @GetMapping(path="/posts/{id}")
    public Response get(@PathVariable int id) {
        Response response = gateway.getPostById(id);
        return response;
    }
}
