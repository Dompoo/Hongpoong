package Dompoo.Hongpoong.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId; // 채팅방 아이디
    private String name; // 채팅방 이름

//    @OneToMany(mappedBy = "chatRoom")
//    private List<ChatMessage> messages = new ArrayList<>();

    @Builder
    public ChatRoom(Long roomId, String name){
        this.roomId = roomId;
        this.name = name;
    }
}
