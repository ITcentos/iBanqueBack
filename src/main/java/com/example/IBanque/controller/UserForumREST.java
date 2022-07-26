package com.example.IBanque.controller;
import com.example.IBanque.model.Message;
import com.example.IBanque.service.UserForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UserForumREST {
    @Autowired
    UserForumService UserForumService;

    @PostMapping("/UserForum/Message")
    public Message save_message(@Valid @RequestBody Message message) {
        return UserForumService.save_message(message);
    }

    @GetMapping("/UserForum/Message/{id}")
    public Optional<Message> get_message(@PathVariable(value = "id") Long id) {

        return UserForumService.find_message(id);
    }

    @GetMapping("/UserForum/allmessages")
    public List<Message> get_messages() {
        return UserForumService.FindAllmessages();
    }

    @GetMapping("/UserForum/MessageByForum/{forumid}")
    public List<Message> findAllForumMessage(@PathVariable(value = "forumid") Long id) {
        return UserForumService.findAllForumMessage(id);
    }

    @DeleteMapping("/UserForum/deletemessage/{id}")
    public String delete_message(@PathVariable(value = "id") Long id) {


        UserForumService.delete_messages(id);
        ;
        return "Post num " + id + " is deleted  successfully ";

    }
}
