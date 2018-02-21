package de.nordakademie.defecttracker.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Embeddable
public class DefectChange {

    private String comment;
    private User editor;
    private LocalDateTime changeTime;
    private DefectStatus previousStatus;
    private DefectStatus newStatus;

    @Column(length = 5000)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @ManyToOne
    public User getEditor() {
        return editor;
    }

    public void setEditor(User editor) {
        this.editor = editor;
    }

    public LocalDateTime getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(LocalDateTime changeTime) {
        this.changeTime = changeTime;
    }

    @Enumerated(EnumType.STRING)
    public DefectStatus getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(DefectStatus previousStatus) {
        this.previousStatus = previousStatus;
    }

    @Enumerated(EnumType.STRING)
    public DefectStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(DefectStatus newStatus) {
        this.newStatus = newStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefectChange that = (DefectChange) o;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (editor != null ? !editor.equals(that.editor) : that.editor != null) return false;
        return changeTime != null ? changeTime.equals(that.changeTime) : that.changeTime == null;
    }

    @Override
    public int hashCode() {
        int result = comment != null ? comment.hashCode() : 0;
        result = 31 * result + (editor != null ? editor.hashCode() : 0);
        result = 31 * result + (changeTime != null ? changeTime.hashCode() : 0);
        return result;
    }
}