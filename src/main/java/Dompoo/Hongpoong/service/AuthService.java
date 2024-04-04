package Dompoo.Hongpoong.service;

import Dompoo.Hongpoong.domain.Member;
import Dompoo.Hongpoong.exception.PasswordNotCorrect;
import Dompoo.Hongpoong.repository.MemberRepository;
import Dompoo.Hongpoong.request.auth.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository repository;

    public void signup(SignupRequest request) {
        if (!Objects.equals(request.getPassword1(), request.getPassword2())) {
            throw new PasswordNotCorrect();
        }

        repository.save(Member.builder()
                .username(request.getUsername())
                .password(request.getPassword1())
                .build());
    }
}
