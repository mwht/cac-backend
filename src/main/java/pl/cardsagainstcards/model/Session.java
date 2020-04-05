package pl.cardsagainstcards.model;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@RedisHash("Session")
public class Session implements Serializable {
    private String id;
    private Integer cardSet;
    private List<Card> usedCards;
    private Player currentPlayer;
    private List<Player> players;

    public Session() {
        this(null, null, null, null, null);
    }

    public Session(String id, Integer cardSet, List<Card> usedCards, Player currentPlayer, List<Player> players) {
        this.id = id;
        this.cardSet = cardSet;
        this.usedCards = usedCards;
        this.currentPlayer = currentPlayer;
        this.players = players;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCardSet() {
        return cardSet;
    }

    public void setCardSet(Integer cardSet) {
        this.cardSet = cardSet;
    }

    public List<Card> getUsedCards() {
        return usedCards;
    }

    public void setUsedCards(List<Card> usedCards) {
        this.usedCards = usedCards;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
