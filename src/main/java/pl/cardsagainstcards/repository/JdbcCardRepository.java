package pl.cardsagainstcards.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.cardsagainstcards.model.CardType;
import pl.cardsagainstcards.model.dto.CardDto;

import java.util.List;

@Repository
public class JdbcCardRepository implements CardRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CardDto> findCardsByParentCardSetAccessionId(String accessionId) {
        return jdbcTemplate.query("SELECT \"cardType\", content FROM cards JOIN cardset ON cardset.id=cards.\"parentCardSet\" WHERE \"accessionId\" = ?;",
                new Object[]{accessionId},
                (rs, rowNum) -> new CardDto(
                    CardType.valueOf(rs.getString("cardType")),
                    rs.getString("content")
                ));
    }
}
