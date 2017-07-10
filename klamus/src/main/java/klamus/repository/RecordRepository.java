package klamus.repository;

import klamus.entity.Record;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sebastian Björkqvist <sebastian@sebastianbjorkqvist.com>
 */
public interface RecordRepository extends CrudRepository<Record, Long> {

    Iterable<Record> findByNameContaining(String name);
}
