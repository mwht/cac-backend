package pl.cardsagainstcards.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.cardsagainstcards.model.Session;

@Repository
public interface SessionRepository extends CrudRepository<Session, String> {}
