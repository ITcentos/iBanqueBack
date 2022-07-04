package com.example.IBanque.service;

import com.example.IBanque.model.Forum;
import com.example.IBanque.model.RendezVous;
import com.example.IBanque.repository.ForumRepository;
import com.example.IBanque.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RendezVousService {


    @Autowired
    RendezVousRepository rendezVousRepository;

    public RendezVous saveourupdate(RendezVous rendezVous) {
        return (RendezVous) rendezVousRepository.save(rendezVous);
    }

    public Optional<RendezVous> find_rendezvous(long id) {
        return rendezVousRepository.findById(id);
    }

    public void delete_rendezvous(long id) {
        rendezVousRepository.deleteById(id);
    }

    public List<RendezVous> FindAllrendezvous() {
        return rendezVousRepository.findAll();
    }

}
