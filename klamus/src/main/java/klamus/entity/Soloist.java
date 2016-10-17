package klamus.entity;

/**
 * Class representing a soloist.
 * 
 * @author Sebastian Björkqvist
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "soloist")
public class Soloist implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long soloistId;
    private String lastName;
    private String firstNames;
    private String info;
    @Column(name="description", columnDefinition="TEXT")
    private String description;
    private Integer yearOfBirth;
    private Integer yearOfDeath;

    protected Soloist() {}

    public Soloist(Long soloistId, String lastName, String firstNames, String info, String description, Integer yearOfBirth, Integer yearOfDeath) {
        this.soloistId = soloistId;
        this.lastName = lastName;
        this.firstNames = firstNames;
        this.info = info;
        this.description = description;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
    }

    public Soloist(String lastName, String firstNames, String info, String description, Integer yearOfBirth, Integer yearOfDeath) {
        this.lastName = lastName;
        this.firstNames = firstNames;
        this.info = info;
        this.description = description;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
    }
    
    public long getSoloistId() {
        return soloistId;
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

    public String getDescription() {
        return description;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public Integer getYearOfDeath() {
        return yearOfDeath;
    }

    @Override
    public String toString() {
        return "Composer{" + "composerId=" + soloistId + ", lastName=" + lastName + ", firstNames=" + firstNames + ", info=" + info + ", description=" + description + ", yearOfBirth=" + yearOfBirth + ", yearOfDeath=" + yearOfDeath + '}';
    }
}
