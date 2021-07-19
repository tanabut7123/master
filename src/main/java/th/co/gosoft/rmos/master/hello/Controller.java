package th.co.gosoft.rmos.master.hello;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @GetMapping(path="/hello/{name}")
    public Response get(@PathVariable String name) {
        return new Response(name);
    }
}