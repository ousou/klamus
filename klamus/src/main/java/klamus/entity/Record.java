package klamus.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Sebastian Björkqvist <sebastian@sebastianbjorkqvist.com>
 */
@Entity
@Table(name = "record")
public class Record implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recordId;
    private String name;
    @Column(name = "description", columnDefinition = "mediumtext")
    private String description;
    private Long storageId;
    private Long mainComposerId;
    private String subStoragePlace;
    private String recordCondition;
    private String code;
    private String recordLabel;
    private String recordType;
    private Integer year;
    @Column(name = "extra_info", columnDefinition = "mediumtext")
    private String extraInfo;
    private Long userId;
    @Transient
    private Iterable<Long> renditionIds;

    protected Record() {
    }

    public Record(Long recordId, String name, String description, Long storageId, Long mainComposerId, String subStoragePlace, String recordCondition, String code, String recordLabel, String recordType, Integer year, String extraInfo, Long userId) {
        this.recordId = recordId;
        this.name = name;
        this.description = description;
        this.storageId = storageId;
        this.mainComposerId = mainComposerId;
        this.subStoragePlace = subStoragePlace;
        this.recordCondition = recordCondition;
        this.code = code;
        this.recordLabel = recordLabel;
        this.recordType = recordType;
        this.year = year;
        this.extraInfo = extraInfo;
        this.userId = userId;
    }

    public Record(String name, String description, Long storageId, Long mainComposerId, String subStoragePlace, String recordCondition, String code, String recordLabel, String recordType, Integer year, String extraInfo, Long userId) {
        this.name = name;
        this.description = description;
        this.storageId = storageId;
        this.mainComposerId = mainComposerId;
        this.subStoragePlace = subStoragePlace;
        this.recordCondition = recordCondition;
        this.code = code;
        this.recordLabel = recordLabel;
        this.recordType = recordType;
        this.year = year;
        this.extraInfo = extraInfo;
        this.userId = userId;
    }
    
    public Long getRecordId() {
        return recordId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getStorageId() {
        return storageId;
    }

    public Long getMainComposerId() {
        return mainComposerId;
    }

    public String getSubStoragePlace() {
        return subStoragePlace;
    }

    public String getRecordCondition() {
        return recordCondition;
    }

    public String getCode() {
        return code;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public String getRecordType() {
        return recordType;
    }

    public Integer getYear() {
        return year;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public Long getUserId() {
        return userId;
    }

    public Iterable<Long> getRenditionIds() {
        return renditionIds;
    }

    public void setRenditionIds(Iterable<Long> renditionIds) {
        this.renditionIds = renditionIds;
    }
    
}
