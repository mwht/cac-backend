package pl.cardsagainstcards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cardsagainstcards.model.Session;
import pl.cardsagainstcards.repository.SessionRepository;
import pl.cardsagainstcards.service.SessionIdProviderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private SessionIdProviderService sessionIdProviderService;

    @GetMapping("/api/session")
    public Iterable<Session> listSessions() {
        return sessionRepository.findAll();
    }

    @GetMapping(value = "/api/session/{id}")
    public ResponseEntity<?> getSessionInfo(@PathVariable String id) {
        Optional<Session> sessionOptional = sessionRepository.findById(id);
        if (sessionOptional.isPresent()) {
            return ResponseEntity.of(sessionOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/api/session", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNewSession(@RequestBody Session session) {
        String id = sessionIdProviderService.getNextId();
        while (sessionRepository.findById(id).isPresent()) {
            id = sessionIdProviderService.getNextId();
        }

        session.setId(id);
        session.setUsedCards(new ArrayList<>());

        if (session.getId() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        if (session.getCardSet() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        session = sessionRepository.save(session);
        return ResponseEntity.status(HttpStatus.CREATED).body(session);
    }

}
