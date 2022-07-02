package com.example.IBanque.controller;


import com.example.IBanque.model.DemCredit;
import com.example.IBanque.model.Forum;
import com.example.IBanque.service.DemCreditService;
import com.example.IBanque.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ForumREST {

    @Autowired
    ForumService forumService;

    @PostMapping("/forum")
    public Forum save_forum(@Valid @RequestBody Forum forum){
        return forumService.saveourupdate(forum);
    }

    @GetMapping("/forum/{id}")
    public Optional<Forum> get_demande(@PathVariable(value="id") Long id ){

        return  forumService.find_forum(id) ;
    }

    @GetMapping("/allforum")
    public List<Forum> get_forums(){
        return  forumService.FindAllforum() ;
    }

    @DeleteMapping("/deleteforum/{id}")
    public String delete_forums(@PathVariable(value="id") Long id ){


        forumService.delete_forum(id); ;
        return "Forum num "+id +" is deleted  successfully ";

    }
}
