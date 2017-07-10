package klamus.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Sebastian Björkqvist <sebastian@sebastianbjorkqvist.com>
 */
@Entity
@Table(name = "work")
public class Work implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long workId;   
    private String name;    
    private Long categoryId;
    private Long composerId;
    private Byte index;
    @Column(name = "description", columnDefinition = "mediumtext")
    private String description;    

    protected Work() {
    }

    public Work(String name, Long categoryId, Long composerId, Byte index, String description) {
        this.name = name;
        this.categoryId = categoryId;
        this.composerId = composerId;
        this.index = index;
        this.description = description;
    }

    public Work(Long workId, String name, Long categoryId, Long composerId, Byte index, String description) {
        this.workId = workId;
        this.name = name;
        this.categoryId = categoryId;
        this.composerId = composerId;
        this.index = index;
        this.description = description;
    }

    public Long getWorkId() {
        return workId;
    }

    public String getName() {
        return name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getComposerId() {
        return composerId;
    }

    public Byte getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }
    
    
}
