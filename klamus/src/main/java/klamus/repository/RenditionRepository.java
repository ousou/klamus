package klamus.repository;

import klamus.entity.Rendition;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sebastian Björkqvist <sebastian@sebastianbjorkqvist.com>
 */
public interface RenditionRepository extends CrudRepository<Rendition, Long> {
    
    Iterable<Rendition> findByNameContaining(String name);
}
