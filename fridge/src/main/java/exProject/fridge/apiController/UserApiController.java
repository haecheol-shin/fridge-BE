package exProject.fridge.apiController;

import exProject.fridge.dto.ResponseDto;
import exProject.fridge.model.User;
import exProject.fridge.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @PostMapping("/api/signup")
    public ResponseDto<Integer> signup(@RequestBody User user) {

        userService.signup(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }


}