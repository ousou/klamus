package klamus.repository;

import java.util.List;
import klamus.entity.UserAccount;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sebastian Björkqvist
 */
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

    /**
     * Finds user by email.
     * 
     * @param email The email of the user
     * @return User with the given email, null if none is found
     */
    UserAccount findByEmail(String email);    
    
    /**
     * Finds users by name.
     * 
     * @param name The name of the user
     * @return List of users with the given name
     */
    List<UserAccount> findByName(String name);     
}
