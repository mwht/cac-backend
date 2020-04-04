package pl.cardsagainstcards.model;

public class CardSet {
    private Integer id;
    private String accessionId;
    private String displayName;

    public CardSet() {
        this (null, null, null);
    }

    public CardSet(Integer id, String accessionId, String displayName) {
        this.id = id;
        this.accessionId = accessionId;
        this.displayName = displayName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessionId() {
        return accessionId;
    }

    public void setAccessionId(String accessionId) {
        this.accessionId = accessionId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
