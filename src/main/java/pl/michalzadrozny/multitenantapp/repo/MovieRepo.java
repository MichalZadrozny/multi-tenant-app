package pl.michalzadrozny.multitenantapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.michalzadrozny.multitenantapp.model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
}
