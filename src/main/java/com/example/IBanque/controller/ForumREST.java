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
@RequestMapping("/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ForumREST {

    @Autowired
    ForumService forumService;

    @PostMapping("/forum/save")
    public Forum save_forum(@Valid @RequestBody Forum forum){
        return forumService.saveourupdate(forum);
    }

    @GetMapping("/forum/{id}")
    public Optional<Forum> get_forum(@PathVariable(value="id") Long id ){

        return  forumService.find_forum(id) ;
    }

    @GetMapping("/forum/allforum")
    public List<Forum> get_forums(){
        return  forumService.FindAllforum() ;
    }

    @DeleteMapping("/forum/deleteforum/{id}")
    public String delete_forum(@PathVariable(value="id") Long id ){


        forumService.delete_forum(id); ;
        return "Forum num "+id +" is deleted  successfully ";

    }

}
