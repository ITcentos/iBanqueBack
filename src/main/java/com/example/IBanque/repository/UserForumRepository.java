package com.example.IBanque.repository;

import com.example.IBanque.model.Message;
import com.example.IBanque.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserForumRepository extends JpaRepository<Message,Long>  {
    @Query(value = "SELECT * FROM Message m WHERE m.forum_id =:forumid",nativeQuery = true)
    List<Message> findAllForumMessage(@Param("forumid") long forumid);


}