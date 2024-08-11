package com.employee.entity;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {
	 @CreatedBy
	    @Column(updatable = false)
	    private String createdBy;

	    @CreatedDate
	    @Column(updatable = false)
	    private LocalDateTime createdDate;

	    @LastModifiedBy
	    private String lastModifiedBy;

	    @LastModifiedDate
	    private LocalDateTime lastModifiedDate;

	    // Getters and setters
	    public String getCreatedBy() {
	        return createdBy;
	    }

	    public void setCreatedBy(String createdBy) {
	        this.createdBy = createdBy;
	    }

	    public LocalDateTime getCreatedDate() {
	        return createdDate;
	    }

	    public void setCreatedDate(LocalDateTime createdDate) {
	        this.createdDate = createdDate;
	    }

	    public String getLastModifiedBy() {
	        return lastModifiedBy;
	    }

	    public void setLastModifiedBy(String lastModifiedBy) {
	        this.lastModifiedBy = lastModifiedBy;
	    }

	    public LocalDateTime getLastModifiedDate() {
	        return lastModifiedDate;
	    }

	    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
	        this.lastModifiedDate = lastModifiedDate;
	    }
	}
