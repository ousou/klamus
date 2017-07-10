package klamus.repository;

import klamus.entity.Storage;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sebastian Björkqvist <sebastian@sebastianbjorkqvist.com>
 */
public interface StorageRepository extends CrudRepository<Storage, Long> {
    
    Iterable<Storage> findByNameContaining(String name);
}
