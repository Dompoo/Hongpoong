package Dompoo.Hongpoong.controller;

import Dompoo.Hongpoong.request.auth.AcceptEmailRequest;
import Dompoo.Hongpoong.request.auth.AddEmailRequest;
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

    @PostMapping("/email")
    public void requstEmail(@RequestBody @Valid AddEmailRequest request) {
        service.addEmail(request);
    }

    //관리자 API
    @PostMapping("/manage/email")
    public void acceptEmail(@RequestBody @Valid AcceptEmailRequest request) {
        service.acceptEmail(request);
    }
}
