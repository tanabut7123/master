package th.co.gosoft.rmos.master.hello;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public Response getHello(String name) {
        return new Response(name);
    }
}
