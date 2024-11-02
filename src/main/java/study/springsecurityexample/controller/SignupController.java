package study.springsecurityexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import study.springsecurityexample.dto.SignupDto;
import study.springsecurityexample.service.UserService;

@RestController
@RequiredArgsConstructor
public class SignupController {

    private final UserService userService;

    @PostMapping("/singup")
    public String adminP(SignupDto signupDto){

        userService.signup(signupDto);
        return "ok";
    }
}
