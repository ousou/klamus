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
@Table(name = "rendition")
public class Rendition implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long renditionId;    
    private String name;
    @Column(name = "description", columnDefinition = "mediumtext")
    private String description;    
    private Long workId;    
    private Long soloistId; 
    private Long conductorId; 

    protected Rendition() {
    }

    public Rendition(String name, String description, Long workId, Long soloistId, Long conductorId) {
        this.name = name;
        this.description = description;
        this.workId = workId;
        this.soloistId = soloistId;
        this.conductorId = conductorId;
    }

    public Rendition(Long renditionId, String name, String description, Long workId, Long soloistId, Long conductorId) {
        this.renditionId = renditionId;
        this.name = name;
        this.description = description;
        this.workId = workId;
        this.soloistId = soloistId;
        this.conductorId = conductorId;
    }

    public Long getRenditionId() {
        return renditionId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getWorkId() {
        return workId;
    }

    public Long getSoloistId() {
        return soloistId;
    }

    public Long getConductorId() {
        return conductorId;
    }
    
}
