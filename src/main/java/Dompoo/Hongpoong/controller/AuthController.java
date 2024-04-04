package Dompoo.Hongpoong.controller;

import Dompoo.Hongpoong.request.auth.SignupRequest;
import Dompoo.Hongpoong.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignupRequest request) {
        service.signup(request);
    }
}
