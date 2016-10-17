package klamus.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Sebastian Björkqvist
 */
@Entity
@Table(name = "useraccount")
public class UserAccount implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;
    private String email;
    private String name;

    protected UserAccount() {}
    
    public UserAccount(Long userId, String email, String name) {
        this.userId = userId;
        this.email = email;
        this.name = name;
    }    
    
    public UserAccount(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
    
}
