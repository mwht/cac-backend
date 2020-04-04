package pl.cardsagainstcards.repository;

import pl.cardsagainstcards.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository {
    Player save(Player player);
    List<Player> findAll();
    Optional<Player> findById(Integer id);
}
