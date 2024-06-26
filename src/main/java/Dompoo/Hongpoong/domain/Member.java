package Dompoo.Hongpoong.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static Dompoo.Hongpoong.domain.Member.Role.ROLE_USER;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String username;
    private String password;
    private Role role;
    private Club club;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Instrument> instruments = new ArrayList<>();

    @ManyToMany
    private List<ChatRoom> chatRooms = new ArrayList<>();

    @OneToOne(mappedBy = "member", cascade = CascadeType.REMOVE)
    private Setting setting;

    public enum Role {
        ROLE_USER("ROLE_CREW"), ROLE_LEADER("ROLE_LEADER"), ROLE_ADMIN("ROLE_ADMIN");

        private final String value;

        Role(String roleUser) {
            this.value = roleUser;
        }
    }

    @Getter
    public enum Club {
        HWARANG("신명화랑"), SANTLE("산틀"), AKBAN("악반"), DEULNEOK("들녘"), ETC("기타");

        private final String value;

        Club(String value) {
            this.value = value;
        }

        public static Club byInt(int value) {
            return switch (value) {
                case 0 -> HWARANG;
                case 1 -> SANTLE;
                case 2 -> AKBAN;
                case 3 -> DEULNEOK;
                default -> ETC;
            };
        }
    }

    @Builder
    public Member(String email, String username, String password, Club club) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.club = club;
        this.role = ROLE_USER;
    }

    public Member(SignUp signUp) {
        this.email = signUp.getEmail();
        this.username = signUp.getEmail();
        this.password = signUp.getPassword();
        this.club = signUp.getClub();
        this.role = ROLE_USER;
    }

    public void joinChatRoom(ChatRoom chatRoom) {
        this.chatRooms.add(chatRoom);
        chatRoom.getMembers().add(this);
    }

    public String getRole() {
        return this.role.value;
    }

    public String getClub() {
        return this.club.value;
    }
}
