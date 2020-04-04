package pl.cardsagainstcards.controller;

import io.swagger.annotations.Info;
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

    /**
     * /api/card/{accessionId} gets all cards which are assigned to given card set, specified by
     * accession ID. This methods always returns a list, regardless whether it's empty or not.
     *
     * @param accessionId Card set accession ID
     * @return List of cards assigned to given card set
     */
    @GetMapping("/api/card/{accessionId}")
    public List<CardDto> getCardsByAccessionId(@PathVariable String accessionId) {
        return cardRepository.findCardsByParentCardSetAccessionId(accessionId);
    }

}
