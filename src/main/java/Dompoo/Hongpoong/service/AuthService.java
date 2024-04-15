package Dompoo.Hongpoong.service;

import Dompoo.Hongpoong.domain.Member;
import Dompoo.Hongpoong.domain.Whitelist;
import Dompoo.Hongpoong.exception.*;
import Dompoo.Hongpoong.repository.MemberRepository;
import Dompoo.Hongpoong.repository.WhitelistRepository;
import Dompoo.Hongpoong.request.auth.AcceptEmailRequest;
import Dompoo.Hongpoong.request.auth.AddEmailRequest;
import Dompoo.Hongpoong.request.auth.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository repository;
    private final WhitelistRepository whitelistRepository;
    private final PasswordEncoder passwordEncoder;


    public void signup(SignupRequest request) {
        if (!Objects.equals(request.getPassword1(), request.getPassword2())) {
            throw new PasswordNotCorrect();
        }

        if (repository.findByUsername(request.getUsername()).isPresent()) {
            throw new AlreadyExistsUsername();
        }

        Whitelist whitelist = whitelistRepository.findByEmail(request.getEmail())
                .orElseThrow(NotInWhitelist::new);

        if (!whitelist.getIsAccepted()) {
            throw new NotAcceptedUser();
        }

        repository.save(Member.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword1()))
                .build());
    }

    public void addEmail(AddEmailRequest request) {
        whitelistRepository.save(Whitelist.builder()
                .email(request.getEmail())
                .isAccepted(false)
                .build());
    }

    public void acceptEmail(AcceptEmailRequest request) {
        Whitelist whitelist = whitelistRepository.findById(request.getId())
                .orElseThrow(EmailNotFound::new);
        if (request.isAcceptResult()) {
            whitelist.setIsAccepted(true);
        } else {
            whitelistRepository.delete(whitelist);
        }
    }
}
