package klamus.repository;

import java.util.List;
import klamus.entity.Conductor;

import org.springframework.data.repository.CrudRepository;

public interface ConductorRepository extends CrudRepository<Conductor, Long> {
    
    /**
     * Finds conductors by last name.
     * 
     * @param lastName The last name of the conductor.
     * @return List of conductors with the given last name.
     */
    List<Conductor> findByLastName(String lastName);
}
