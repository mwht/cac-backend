package pl.cardsagainstcards.model.dto;

import pl.cardsagainstcards.model.CardType;

public class CardDto {
    private CardType cardType;
    private String content;

    public CardDto(CardType cardType, String content) {
        this.cardType = cardType;
        this.content = content;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
