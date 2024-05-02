package Dompoo.Hongpoong.service;

import Dompoo.Hongpoong.domain.Member;
import Dompoo.Hongpoong.domain.Setting;
import Dompoo.Hongpoong.exception.MemberNotFound;
import Dompoo.Hongpoong.repository.MemberRepository;
import Dompoo.Hongpoong.request.common.SettingRequest;
import Dompoo.Hongpoong.response.SettingResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CommonService {

    private final MemberRepository memberRepository;

    public SettingResponse getSetting(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(MemberNotFound::new);

        return new SettingResponse(member.getSetting());
    }

    public void setting(Long memberId, SettingRequest request) {
        Setting setting = memberRepository.findById(memberId)
                .orElseThrow(MemberNotFound::new)
                .getSetting();

        setting.setPush(request.isPush());
    }
}
