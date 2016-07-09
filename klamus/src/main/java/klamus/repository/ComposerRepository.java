package klamus.repository;

import klamus.entity.Composer;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ComposerRepository extends CrudRepository<Composer, Long> {

    List<Composer> findByLastName(String lastName);
}
