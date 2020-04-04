package pl.cardsagainstcards.model;

public class Card {
    private Integer id;
    private CardSet parentCardSet;
    private CardType cardType;
    private String content;

    public Card(Integer id, CardSet parentCardSet, CardType cardType, String content) {
        this.id = id;
        this.parentCardSet = parentCardSet;
        this.cardType = cardType;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CardSet getParentCardSet() {
        return parentCardSet;
    }

    public void setParentCardSet(CardSet parentCardSet) {
        this.parentCardSet = parentCardSet;
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
