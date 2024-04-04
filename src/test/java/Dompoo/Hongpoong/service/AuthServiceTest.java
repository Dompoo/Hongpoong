package Dompoo.Hongpoong.service;

import Dompoo.Hongpoong.exception.PasswordNotCorrect;
import Dompoo.Hongpoong.repository.MemberRepository;
import Dompoo.Hongpoong.request.auth.SignupRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AuthServiceTest {

    @Autowired
    private AuthService service;
    @Autowired
    private MemberRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("회원가입")
    void signup() {
        //given
        SignupRequest request = SignupRequest.builder()
                .username("창근")
                .password1("1234")
                .password2("1234")
                .build();

        //when
        service.signup(request);

        //then
        assertEquals(repository.count(), 1);
        assertEquals(repository.findAll().getFirst().getUsername(), "창근");
        assertEquals(repository.findAll().getFirst().getPassword(), "1234");
    }

    @Test
    @DisplayName("회원가입시 비밀번호와 비밀번호확인은 일치해야 한다.")
    void signupFail() {
        //given
        SignupRequest request = SignupRequest.builder()
                .username("창근")
                .password1("1234")
                .password2("5678")
                .build();

        //when
        PasswordNotCorrect e = assertThrows(PasswordNotCorrect.class, () ->
                service.signup(request));


        //then
        assertEquals(e.statusCode(), "400");
        assertEquals(e.getMessage(), "비밀번호가 일치하지 않습니다.");
    }

}