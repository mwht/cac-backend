package pl.cardsagainstcards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cardsagainstcards.model.CardSet;
import pl.cardsagainstcards.repository.CardSetRepository;

import java.util.List;

@RestController
public class CardSetController {

    @Autowired
    private CardSetRepository cardSetRepository;

    @GetMapping("/api/cardset")
    public List<CardSet> getAllAvailableCardsets() {
        return cardSetRepository.findAll();
    }

}
