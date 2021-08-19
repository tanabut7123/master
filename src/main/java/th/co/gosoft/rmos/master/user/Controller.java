package th.co.gosoft.rmos.master.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController(value="userController")
public class Controller {

    @Autowired
    UserRepository userRepository;

    @GetMapping(path="/users/{userId}")
    public User get(@PathVariable Long userId) {
        System.out.println(">>>>>>>>>>>>>>>>>>>> ID is "+userId);
        Optional<User> user = userRepository.findById(userId);
        /*
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
        );*/
        return user.get();
    }

    @PostMapping(path="/user")
    public ResponseEntity<String> post(@Valid @RequestBody UserRequest userRequest) {
        User user = userRepository.save(new User(userRequest));
        return new ResponseEntity<String>(String.valueOf(user.getId()), HttpStatus.CREATED);
    }
}
