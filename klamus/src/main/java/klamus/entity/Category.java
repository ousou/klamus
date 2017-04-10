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
 * @author Sebastian Björkqvist
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long categoryId;
    private String name;
    @Column(name="description", columnDefinition="mediumtext")
    private Long parentCategoryId;
    private Boolean canStoreHere;
    private Long userId;

    protected Category() {}
    
    public Category(Long categoryId, String name, Long parentCategoryId, Boolean canStoreHere, Long userId) {
        this.categoryId = categoryId;
        this.name = name;
        this.parentCategoryId = parentCategoryId;
        this.canStoreHere = canStoreHere;
        this.userId = userId;
    }

    public Category(String name, Long parentCategoryId, Boolean canStoreHere, Long userId) {
        this.name = name;
        this.parentCategoryId = parentCategoryId;
        this.canStoreHere = canStoreHere;
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public Boolean getCanStoreHere() {
        return canStoreHere;
    }

    public Long getUserId() {
        return userId;
    }
    
}
