package springBootApp.entities;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ChatDAO extends CrudRepository<Chat, Long> {
}

