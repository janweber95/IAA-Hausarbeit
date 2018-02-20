package de.nordakademie.defecttracker.model;


import javax.persistence.*;
import java.time.LocalDateTime;

import static de.nordakademie.defecttracker.model.DefectStatus.CREATED;

@Entity
public class Defect {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private User creator;
    private DefectStatus status = CREATED;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(length = 20000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @ManyToOne
    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Enumerated(EnumType.STRING)
    public DefectStatus getStatus() {
        return status;
    }

    public void setStatus(DefectStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        if (title != null ? !title.equals(defect.title) : defect.title != null) return false;
        if (description != null ? !description.equals(defect.description) : defect.description != null) return false;
        if (creationDate != null ? !creationDate.equals(defect.creationDate) : defect.creationDate != null)
            return false;
        if (creator != null ? !creator.equals(defect.creator) : defect.creator != null) return false;
        return status == defect.status;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}