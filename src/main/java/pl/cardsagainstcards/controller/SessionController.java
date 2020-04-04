package pl.cardsagainstcards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.cardsagainstcards.model.Session;
import pl.cardsagainstcards.repository.SessionRepository;
import pl.cardsagainstcards.service.SessionIdProviderService;

import java.util.ArrayList;

@RestController
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private SessionIdProviderService sessionIdProviderService;

    @PostMapping(value = "/api/session", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> createNewSession(@RequestBody Session session) {
        session.setId(sessionIdProviderService.getNextId());
        session.setUsedCards(new ArrayList<>());

        if (session.getId() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        if (session.getCardSet() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        session = sessionRepository.save(session);
        return ResponseEntity.status(HttpStatus.CREATED).body(session);
    }

}
