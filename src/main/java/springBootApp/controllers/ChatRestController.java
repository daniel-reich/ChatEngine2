package springBootApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springBootApp.entities.Chat;
import springBootApp.entities.ChatDAO;
import java.sql.Timestamp;


@RestController
@RequestMapping("/chat/")
public class ChatRestController {

    @Autowired
    private ChatDAO chatDAO;

    @RequestMapping("help")
    public String chatHelp() {
        return "<h1>REST Chat Help!</h1>" +
                "Use the following Commands:<br><br>" +
                "SEND CHAT MESSAGE: /chat/send?message=[message]<br>" +
                "VIEW ALL CHATS: /chat/<br>" +
                "CHAT HELP: /chat/help";
    }

    @RequestMapping("/")
    public Iterable<Chat> showChats() {
        return chatDAO.findAll();
    }

    @RequestMapping("send")
    public String sendChat(String message) {
        try {
            Chat chat = new Chat();
            chat.setMessage(message);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            chat.setSender(auth.getName());
            chat.setWhenSent(new Timestamp(System.currentTimeMillis()));
            chatDAO.save(chat);
            return "Message send successfully.";
        } catch (Exception e) {
            return "Error sending chat message: " + e.toString();
        }
    }

}

