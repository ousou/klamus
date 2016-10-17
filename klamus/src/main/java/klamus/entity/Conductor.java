package klamus.entity;

/**
 * Class representing a conductor.
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
@Table(name = "conductor")
public class Conductor implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long conductorId;
    private String lastName;
    private String firstNames;
    private String info;
    @Column(name="description", columnDefinition="TEXT")
    private String description;
    private Integer yearOfBirth;
    private Integer yearOfDeath;

    protected Conductor() {}

    public Conductor(long conductorId, String lastName, String firstNames, String info, String description, Integer yearOfBirth, Integer yearOfDeath) {
        this.conductorId = conductorId;
        this.lastName = lastName;
        this.firstNames = firstNames;
        this.info = info;
        this.description = description;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
    }

    public Conductor(String lastName, String firstNames, String info, String description, Integer yearOfBirth, Integer yearOfDeath) {
        this.lastName = lastName;
        this.firstNames = firstNames;
        this.info = info;
        this.description = description;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
    }
    
    public long getConductorId() {
        return conductorId;
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
        return "Composer{" + "composerId=" + conductorId + ", lastName=" + lastName + ", firstNames=" + firstNames + ", info=" + info + ", description=" + description + ", yearOfBirth=" + yearOfBirth + ", yearOfDeath=" + yearOfDeath + '}';
    }
}
