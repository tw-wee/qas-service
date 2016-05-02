package tw.wee.qas.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public abstract class Auditor {
    @Column(name = "time_created", nullable = false, updatable = false)
    @CreatedDate
    private Date timeCreated = new Date();

    @Column(name = "last_modified", nullable = false)
    @LastModifiedDate
    private Date lastModified = new Date();

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}
