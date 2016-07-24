package klamus.repository;

import klamus.entity.Composer;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ComposerRepository extends CrudRepository<Composer, Long> {
    
    /**
     * Finds composers by last name.
     * 
     * @param lastName The last name of the composer.
     * @return List of composers with the given last name.
     */
    List<Composer> findByLastName(String lastName);
}
