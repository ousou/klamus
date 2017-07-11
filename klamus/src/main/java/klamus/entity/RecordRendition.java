package klamus.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Sebastian Björkqvist <sebastian@sebastianbjorkqvist.com>
 */
@Entity
@Table(name = "record_rendition")
public class RecordRendition implements Serializable {
    @Id
    private Long recordId; 
    private Long renditionId;  
    private Integer orderNumber;

    protected RecordRendition() {
    }
    
    public RecordRendition(Long recordId, Long renditionId, Integer orderNumber) {
        this.recordId = recordId;
        this.renditionId = renditionId;
        this.orderNumber = orderNumber;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getRenditionId() {
        return renditionId;
    }

    public void setRenditionId(Long renditionId) {
        this.renditionId = renditionId;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    
}
