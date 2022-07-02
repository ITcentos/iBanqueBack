package com.example.IBanque.service;

import com.example.IBanque.model.DemCredit;
import com.example.IBanque.model.Forum;
import com.example.IBanque.repository.DemCreditRepository;
import com.example.IBanque.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForumService {

    @Autowired
    ForumRepository forumRepository;

    public Forum saveourupdate(Forum forum) {
        return (Forum) forumRepository.save(forum);
    }

    public Optional<Forum> find_forum(long id) {
        return forumRepository.findById(id);
    }

    public void delete_forum(long id) {
        forumRepository.deleteById(id);
    }

    public List<Forum> FindAllforum() {
        return forumRepository.findAll();
    }
}
