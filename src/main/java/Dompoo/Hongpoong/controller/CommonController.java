package Dompoo.Hongpoong.controller;

import Dompoo.Hongpoong.config.security.UserPrincipal;
import Dompoo.Hongpoong.request.common.SettingRequest;
import Dompoo.Hongpoong.response.SettingResponse;
import Dompoo.Hongpoong.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/common")
public class CommonController {

    private final CommonService service;

    @GetMapping("/setting")
    public SettingResponse getSetting(@AuthenticationPrincipal UserPrincipal principal) {
        return service.getSetting(principal.getMemberId());
    }

    @PutMapping("/setting")
    public void setting(@AuthenticationPrincipal UserPrincipal principal, @RequestBody SettingRequest request) {
        service.setting(principal.getMemberId(), request);
    }
}
