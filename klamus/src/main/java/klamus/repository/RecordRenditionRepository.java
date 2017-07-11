package klamus.repository;

import klamus.entity.RecordRendition;
import klamus.entity.RecordRendition.RecordRenditionKey;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sebastian Björkqvist <sebastian@sebastianbjorkqvist.com>
 */
public interface RecordRenditionRepository extends CrudRepository<RecordRendition, RecordRenditionKey> {
    
    Iterable<RecordRendition> findByRecordIdOrderByOrderNumber(Long recordId);
    
    Iterable<RecordRendition> findByRenditionId(Long renditionId);
}
