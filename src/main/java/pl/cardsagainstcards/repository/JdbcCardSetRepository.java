package pl.cardsagainstcards.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.cardsagainstcards.model.CardSet;

import java.util.List;

@Repository
public class JdbcCardSetRepository implements CardSetRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        Integer result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM cardset;", Integer.class);
        return result != null ? result : 0;
    }

    @Override
    public List<CardSet> findAll() {
        return jdbcTemplate.query("SELECT id, \"accessionId\", \"displayName\" FROM cardset;", (rs, rowNum) -> new CardSet(
                rs.getInt("id"),
                rs.getString("accessionId"),
                rs.getString("displayName")
        ));
    }
}
