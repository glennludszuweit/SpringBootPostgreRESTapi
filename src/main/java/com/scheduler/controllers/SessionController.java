package com.scheduler.controllers;

import com.scheduler.models.Session;
import com.scheduler.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionRepository.getReferenceById(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    @PutMapping("{id}")
    public Session update(@PathVariable Long id, @RequestBody Session session) {
       Session sessionToUpdate =  sessionRepository.getReferenceById(id);
        BeanUtils.copyProperties(session, sessionToUpdate, "session_id");
        return sessionRepository.saveAndFlush(sessionToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        sessionRepository.deleteById(id);
    }
}
