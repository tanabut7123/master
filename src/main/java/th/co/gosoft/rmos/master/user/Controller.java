package th.co.gosoft.rmos.master.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import th.co.gosoft.rmos.master.user.Response;

@RestController(value="userController")
public class Controller {
    @GetMapping(path="/users/{userId}")
    public Response get(@PathVariable String userId) {
        Response response = new Response(
                1,
                "Leanne Graham",
                "Bret",
                "Sincere@april.biz",
                new Address(
                        "Kulas Light",
                        "Apt. 556",
                        "Gwenborough",
                        "92998-3874",
                        new Geo(
                                "-37.3159",
                                "81.1496"
                        )
                ),
                "1-770-736-8031 x56442",
                "hildegard.org",
                new Company(
                        "Romaguera-Crona",
                        "Multi-layered client-server neural-net",
                        "harness real-time e-markets"
                )
        );
        return response;
    }
}
