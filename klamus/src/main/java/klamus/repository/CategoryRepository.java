package klamus.repository;

import java.util.List;
import klamus.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sebastian Björkqvist
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
    /**
     * Finds categories of a user by name.
     * 
     * @param name The name of the category
     * @param userId The id of the user
     * @return List of categories of the given user with the given name
     */
    List<Category> findByNameAndUserId(String name, Long userId);
    
    /**
     * Finds categories of a user.
     * 
     * @param userId The id of the user
     * @return List of categories of the given user
     */
    List<Category> findByUserId(Long userId);    
}
