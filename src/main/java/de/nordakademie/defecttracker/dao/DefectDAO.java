package de.nordakademie.defecttracker.dao;


import de.nordakademie.defecttracker.model.Defect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefectDAO extends JpaRepository<Defect, Long> {

}