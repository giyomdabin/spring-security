package study.springsecurityexample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import study.springsecurityexample.dto.SignupDto;
import study.springsecurityexample.entity.UserEntity;
import study.springsecurityexample.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void signup(SignupDto signupDto){

        String email = signupDto.getEmail();
        String password = signupDto.getPassword();

        if(userRepository.findByEmail(email).isPresent()){
            return;
        }

        UserEntity userEntity= new UserEntity();
        userEntity.setEmail(email);
        userEntity.setPassword(bCryptPasswordEncoder.encode(password));
        userEntity.setRole("ADMIN");

        userRepository.save(userEntity);
    }
}
