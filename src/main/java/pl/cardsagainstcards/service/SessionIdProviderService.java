package pl.cardsagainstcards.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionIdProviderService {

    public String getNextId() {
        return UUID.randomUUID().toString();
    }

}
