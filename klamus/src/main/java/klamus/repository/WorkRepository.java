package klamus.repository;

import klamus.entity.Work;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sebastian Björkqvist <sebastian@sebastianbjorkqvist.com>
 */
public interface WorkRepository extends CrudRepository<Work, Long> {

    Iterable<Work> findByNameContaining(String name);
    
}
