package klamus.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import klamus.entity.RecordRendition.RecordRenditionKey;

/**
 *
 * @author Sebastian Björkqvist <sebastian@sebastianbjorkqvist.com>
 */
@Entity
@IdClass(RecordRenditionKey.class)
@Table(name = "record_rendition")
public class RecordRendition implements Serializable {
    @Id
    private Long recordId; 
    private Long renditionId;  
    @Id
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

    @Override
    public String toString() {
        return "RecordRendition{" + "recordId=" + recordId + ", renditionId=" + renditionId + ", orderNumber=" + orderNumber + '}';
    }
    
    public static class RecordRenditionKey implements Serializable {
        private Long recordId; 
        private Integer orderNumber;

        protected RecordRenditionKey() {
        }
        
        @Override
        public int hashCode() {
            int hash = 7;
            hash = 47 * hash + Objects.hashCode(this.recordId);
            hash = 47 * hash + Objects.hashCode(this.orderNumber);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final RecordRenditionKey other = (RecordRenditionKey) obj;
            if (!Objects.equals(this.recordId, other.recordId)) {
                return false;
            }
            if (!Objects.equals(this.orderNumber, other.orderNumber)) {
                return false;
            }
            return true;
        }
        
        
    }
   
}
