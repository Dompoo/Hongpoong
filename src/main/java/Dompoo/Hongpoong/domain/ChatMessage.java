package Dompoo.Hongpoong.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatMessage {
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;

    public enum MessageType {
        ENTER, TALK
    }
}
