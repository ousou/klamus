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
@Table(name = "musicalwork")
public class Work implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long workId;   
    private String name;    
    private Long categoryId;
    private Long composerId;
    private Integer orderNumber;
    @Column(name = "description", columnDefinition = "mediumtext")
    private String description;    

    protected Work() {
    }

    public Work(String name, Long categoryId, Long composerId, Integer orderNumber, String description) {
        this.name = name;
        this.categoryId = categoryId;
        this.composerId = composerId;
        this.orderNumber = orderNumber;
        this.description = description;
    }

    public Work(Long workId, String name, Long categoryId, Long composerId, Integer orderNumber, String description) {
        this.workId = workId;
        this.name = name;
        this.categoryId = categoryId;
        this.composerId = composerId;
        this.orderNumber = orderNumber;
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

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public String getDescription() {
        return description;
    }
    
    
}
