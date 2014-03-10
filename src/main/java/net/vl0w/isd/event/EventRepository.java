package net.vl0w.isd.event;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
	List<Event> findByName(String name);

	Event getByName(String name);
}
