package study.springsecurityexample.dto;

import lombok.Data;

@Data
public class SignupDto {
    private String password;
    private String email;
    private String role;
}
