package Dompoo.Hongpoong.service;

import Dompoo.Hongpoong.domain.Member;
import Dompoo.Hongpoong.exception.AlreadyExistsUsername;
import Dompoo.Hongpoong.exception.PasswordNotCorrect;
import Dompoo.Hongpoong.repository.MemberRepository;
import Dompoo.Hongpoong.request.auth.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository repository;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignupRequest request) {
        if (!Objects.equals(request.getPassword1(), request.getPassword2())) {
            throw new PasswordNotCorrect();
        }

        if (repository.findByUsername(request.getUsername()).isPresent()) {
            throw new AlreadyExistsUsername();
        }

        repository.save(Member.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword1()))
                .build());
    }
}
