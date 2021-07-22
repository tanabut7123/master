package th.co.gosoft.rmos.master.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @GetMapping(path="/hello/{name}")
    public Response get(@PathVariable String name) {
        return new Response(name);
    }

    @GetMapping(path="/hello")
    public List<Response> getAll(@RequestParam(defaultValue = "1") String type) {
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
    public ResponseEntity<String> post(@RequestBody HelloRequest helloRequest) {
        if("tanabut".equalsIgnoreCase(helloRequest.getName()))
            return new ResponseEntity<String>("1", HttpStatus.CREATED);

        throw new InvalidNameException();
    }
}