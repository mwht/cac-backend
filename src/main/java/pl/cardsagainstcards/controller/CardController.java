package pl.cardsagainstcards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.cardsagainstcards.model.dto.CardDto;
import pl.cardsagainstcards.repository.CardRepository;

import java.util.List;

@RestController
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @GetMapping("/api/cards/{accessionId}")
    public List<CardDto> getCardsByAccessionId(@PathVariable String accessionId) {
        return cardRepository.findCardsByParentCardSetAccessionId(accessionId);
    }

}
