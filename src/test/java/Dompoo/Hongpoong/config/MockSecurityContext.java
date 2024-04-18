package Dompoo.Hongpoong.config;

import Dompoo.Hongpoong.domain.Member;
import Dompoo.Hongpoong.repository.MemberRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.List;

public class MockSecurityContext implements WithSecurityContextFactory<WithMockMember> {
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;

    @Override
    public SecurityContext createSecurityContext(WithMockMember annotation) {
        Member member = Member.builder()
                .email(annotation.email())
                .username(annotation.username())
                .password(encoder.encode(annotation.password()))
                .build();

        memberRepository.save(member);

        UserPrincipal principal = new UserPrincipal(member);

        SimpleGrantedAuthority role = new SimpleGrantedAuthority(annotation.role());

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(principal, member.getPassword(), List.of(role));

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authToken);

        return context;
    }

    public MockSecurityContext(MemberRepository memberRepository, PasswordEncoder encoder) {
        this.memberRepository = memberRepository;
        this.encoder = encoder;
    }
}
