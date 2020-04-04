package pl.cardsagainstcards.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.cardsagainstcards.model.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcPlayerRepository implements PlayerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Player save(Player player) {
        /* check if player exists first */
        boolean isUpdating = false;
        if (player.getId() != null) {
            Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM players WHERE id = ?;", new Object[]{player.getId()}, Integer.class);
            if (count != null && count > 0) {
                isUpdating = true;
            }
        }

        String statement = isUpdating ? "UPDATE players SET username = ?, password = ?, email = ?, lastseen = ?, enabled = ?, webadmin = ? WHERE id = ?;" :
                "INSERT INTO players (username, password, email, lastseen, enabled, webadmin) VALUES (?, ?, ?, ?, ?, ?);";

        if (isUpdating)
            jdbcTemplate.update(statement, player.getUsername(), player.getPassword(), player.getEmail(), player.getLastseen(), player.getEnabled(), player.getWebadmin(), player.getId());
        else
            jdbcTemplate.update(statement, player.getUsername(), player.getPassword(), player.getEmail(), player.getLastseen(), player.getEnabled(), player.getWebadmin());

        Integer insertedId = jdbcTemplate.queryForObject("SELECT currval(pg_get_serial_sequence('players', 'id')) AS inserted_id;", Integer.class);
        player.setId(insertedId);
        return player;
    }

    @Override
    public List<Player> findAll() {
        return jdbcTemplate.query("SELECT id, username, password, email, lastseen, enabled, webadmin FROM players;",
                (rs, rowNum) -> new Player(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getDate("lastseen"),
                    rs.getBoolean("enabled"),
                    rs.getBoolean("webadmin")
                )
        );
    }

    @Override
    public Optional<Player> findById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT id, username, password, email, lastseen, enabled, webadmin FROM players WHERE id = ?;",
                new Object[]{id},
                (rs, rowNum) -> Optional.of(new Player(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getDate("lastseen"),
                        rs.getBoolean("enabled"),
                        rs.getBoolean("webadmin")
                )
        ));
    }
}
