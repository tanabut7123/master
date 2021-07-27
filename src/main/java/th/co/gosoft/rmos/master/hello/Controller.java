package th.co.gosoft.rmos.master.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
public class Controller {
    @Autowired
    HelloService helloService;

    public Controller(HelloService helloService) {
        this.helloService = helloService;
    }

    public Controller() {
    }

    @GetMapping(path="/hello/{name}")
    public Response get(@PathVariable String name) {
        return helloService.getHello(name);
    }

    @GetMapping(path="/helloo")
    public Response getAll(@RequestParam @Min(50) int count) {
        return new Response(String.valueOf(count));
    }

    @GetMapping(path="/hello")
    public List<Response> getAll(@RequestParam String type) {
        List<Response> responseList = new ArrayList<>();
        responseList.add(new Response("A"));
        responseList.add(new Response("B"));
        responseList.add(new Response("C"));
        responseList.add(new Response("D"));

        if(!type.equals("1")) {
            responseList.add(new Response("E"));
            responseList.add(new Response("F"));
            responseList.add(new Response("G"));
        }
        return responseList;
    }

    @PostMapping(path="/hello")
    public ResponseEntity<String> post(@Valid @RequestBody HelloRequest helloRequest) {
        return new ResponseEntity<String>("1", HttpStatus.CREATED);
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    public Response get(HelloService helloService, String name) {
        this.helloService = helloService;
        return get(name);
    }
}