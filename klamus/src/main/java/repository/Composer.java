package repository;

/**
 *
 * @author Sebastian Björkqvist
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "composer")
public class Composer implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long composerId;
    private String lastName;
    private String firstNames;
    private String info;

    protected Composer() {}

    public Composer(String lastName, String firstNames, String info) {
        this.lastName = lastName;
        this.firstNames = firstNames;
        this.info = info;
    }

    public Composer(long composerId, String lastName, String firstNames, String info) {
        this.composerId = composerId;
        this.lastName = lastName;
        this.firstNames = firstNames;
        this.info = info;
    }

    public long getComposerId() {
        return composerId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "Composer{" + "composerId=" + composerId + ", lastName=" + lastName + ", firstNames=" + firstNames + ", info=" + info + '}';
    }
    
}
