package pl.cardsagainstcards.service;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class SessionIdProviderService {
    private final Random random = new Random();

    public String getNextId() {
        int id = random.nextInt(899999999) + 100000000;
        return Integer.toString(id);
    }

}
