package com.example.IBanque.service;

import com.example.IBanque.model.Message;
import com.example.IBanque.repository.UserForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@Service
public class UserForumService {
    @Autowired
    UserForumRepository UserForumRepository;
    public Message save_message(@Valid Message message) {
        return (Message) UserForumRepository.save(message);
    }

    public Optional<Message> find_message(long id) {
        return UserForumRepository.findById(id);
    }

    public List<Message> findAllForumMessage(long id)  {
        return UserForumRepository.findAllForumMessage(id);
    }

    public void delete_messages(long id) {
        UserForumRepository.deleteById(id);
    }

    public List<Message> FindAllmessages() {
        return UserForumRepository.findAll();
    }

}
