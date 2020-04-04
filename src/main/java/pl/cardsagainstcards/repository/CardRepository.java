package pl.cardsagainstcards.repository;

import pl.cardsagainstcards.model.dto.CardDto;

import java.util.List;

public interface CardRepository {
    List<CardDto> findCardsByParentCardSetAccessionId(String accessionId);
}
