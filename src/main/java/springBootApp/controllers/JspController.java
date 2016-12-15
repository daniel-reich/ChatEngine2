package springBootApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springBootApp.entities.Chat;
import springBootApp.entities.ChatDAO;
import springBootApp.entities.UserDao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

@Controller
@RequestMapping(value="/jsp/")
public class JspController {

    @Autowired
    private ChatDAO chatDAO;

    @RequestMapping(value="viewAll")
    public String viewAll(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String sender = auth.getName();
        Iterable<Chat> i = chatDAO.findAll();
        Iterator<Chat> itr = i.iterator();
        ArrayList<Chat> chats = new ArrayList<>();
        ArrayList<Chat> myChats = new ArrayList<>();
        while(itr.hasNext()) {
            Chat chat = itr.next();
            chats.add(chat);
            if (chat.getSender().equals(sender)){
                myChats.add(chat);
            }
        }
        model.addAttribute("myChats", myChats);
        model.addAttribute("chats", chats);
        return "chatScreen";
    }

    @RequestMapping(value="newMessage")
    public String newMessage(Model model, String message){
        try {
            Chat chat = new Chat();
            chat.setMessage(message);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            chat.setSender(auth.getName());
            chat.setWhenSent(new Timestamp(System.currentTimeMillis()));
            chatDAO.save(chat);
            return "redirect:/jsp/viewAll";
        } catch (Exception e) {
            return "redirect:/jsp/viewAll";
        }
    }
}
