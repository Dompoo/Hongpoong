package Dompoo.Hongpoong.controller;

import Dompoo.Hongpoong.domain.ChatRoom;
import Dompoo.Hongpoong.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    private final ChatService service;

    @PostMapping
    public ChatRoom createRoom(@RequestParam String name) {
        return service.createRoom(name);
    }

    @GetMapping
    public List<ChatRoom> findAllRoom() {
        return service.findAllRoom();
    }
}
