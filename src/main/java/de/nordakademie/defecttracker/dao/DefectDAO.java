package de.nordakademie.defecttracker.dao;


import de.nordakademie.defecttracker.model.Defect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * DAO for defect entities.
 *
 * @author Jan-Philipp Weber
 */
public interface DefectDAO extends JpaRepository<Defect, Long> {

    /**
     * Lists all defects that are not closed.
     *
     * @return a list of defect entities with a status that is not {@code CLOSED}.
     * An empty list is returned if no defect that is not closed was found.
     */
    @Query("SELECT d FROM Defect d WHERE NOT d.status = 'CLOSED'")
    List<Defect> findAllNonClosed();
}