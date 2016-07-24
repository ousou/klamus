package klamus.repository;

import klamus.entity.Soloist;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SoloistRepository extends CrudRepository<Soloist, Long> {
    
    /**
     * Finds soloists by last name.
     * 
     * @param lastName The last name of the soloist.
     * @return List of soloists with the given last name.
     */
    List<Soloist> findByLastName(String lastName);
}
