package com.example.IBanque.repository;

import com.example.IBanque.model.Forum;
import com.example.IBanque.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum,Long>  {
}
