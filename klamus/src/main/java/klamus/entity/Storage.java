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
@Table(name = "storage")
public class Storage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storageId;   
    private String name;
    @Column(name = "description", columnDefinition = "mediumtext")
    private String description;
    private Long parentStorageId;
    private Byte canStoreHere;
    private Long userId;

    protected Storage() {
    }

    public Storage(String name, String description, Long parentStorageId, Byte canStoreHere, Long userId) {
        this.name = name;
        this.description = description;
        this.parentStorageId = parentStorageId;
        this.canStoreHere = canStoreHere;
        this.userId = userId;
    }

    public Storage(Long storageId, String name, String description, Long parentStorageId, Byte canStoreHere, Long userId) {
        this.storageId = storageId;
        this.name = name;
        this.description = description;
        this.parentStorageId = parentStorageId;
        this.canStoreHere = canStoreHere;
        this.userId = userId;
    }

    public Long getStorageId() {
        return storageId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getParentStorageId() {
        return parentStorageId;
    }

    public Byte getCanStoreHere() {
        return canStoreHere;
    }

    public Long getUserId() {
        return userId;
    }
    
    
}
