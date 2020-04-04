package pl.cardsagainstcards.model;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@RedisHash("Session")
public class Session implements Serializable {
    private String id;
    private Integer cardSet;
    private List<Card> usedCards;

    public Session() {
        this(null, null, null);
    }

    public Session(String id, Integer cardSet, List<Card> usedCards) {
        this.id = id;
        this.cardSet = cardSet;
        this.usedCards = usedCards;
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
}
