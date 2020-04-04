package pl.cardsagainstcards.repository;

import pl.cardsagainstcards.model.CardSet;

import java.util.List;

public interface CardSetRepository {
    int count();
    List<CardSet> findAll();
}
