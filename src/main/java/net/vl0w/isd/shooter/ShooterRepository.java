package net.vl0w.isd.shooter;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShooterRepository extends MongoRepository<Shooter, String> {
	Shooter findByFirstName(String firstName);

	List<Shooter> findByLastName(String lastName);
}
