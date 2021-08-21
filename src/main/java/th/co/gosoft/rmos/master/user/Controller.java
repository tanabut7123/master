package th.co.gosoft.rmos.master.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.co.gosoft.rmos.master.user.request.UserRequest;
import th.co.gosoft.rmos.master.user.response.UserResponse;

import javax.validation.Valid;
import java.util.Optional;

@RestController(value="userController")
public class Controller {

    @Autowired
    UserRepository userRepository;

    @GetMapping(path="/users/{userId}")
    public UserResponse get(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent())
            return new UserResponse(user.get());
        throw new UserNotFoundException();
    }

    @PostMapping(path="/user")
    public ResponseEntity<String> post(@Valid @RequestBody UserRequest userRequest) {
        User user = userRepository.save(new User(userRequest));
        return new ResponseEntity<String>(String.valueOf(user.getId()), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/user/{userId}")
    public void delete(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }
}
