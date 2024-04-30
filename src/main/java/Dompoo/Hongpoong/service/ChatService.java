package Dompoo.Hongpoong.service;

import Dompoo.Hongpoong.domain.ChatRoom;
import Dompoo.Hongpoong.repository.ChatRoomRepository;
import Dompoo.Hongpoong.request.chat.ChatRoomCreateRequest;
import Dompoo.Hongpoong.response.ChatRoomResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Data
public class ChatService {

    private final ChatRoomRepository repository;

    public ChatRoom createRoom(ChatRoomCreateRequest request){
        ChatRoom chatRoom = ChatRoom.builder()
                .name(request.getName())
                .build();
        return repository.save(chatRoom);
    }

    public List<ChatRoomResponse> findAll(){
        return repository.findAll().stream()
                .map(ChatRoomResponse::new)
                .collect(Collectors.toList());
    }

//    public ChatRoomDetailResponse findOne(Long roomId){
//        ChatRoom chatRoom = repository.findById(roomId)
//                .orElseThrow(ChatRoomNotFound::new);
//
//        return new ChatRoomDetailResponse(chatRoom);
//    }
}
