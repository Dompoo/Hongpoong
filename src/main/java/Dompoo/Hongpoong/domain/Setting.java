package Dompoo.Hongpoong.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Member member;

    private boolean push;

    @Builder
    public Setting(Member member) {
        setMember(member);
        this.push = false;
    }

    public void setMember(Member member) {
        this.member = member;
        member.setSetting(this);
    }
}
