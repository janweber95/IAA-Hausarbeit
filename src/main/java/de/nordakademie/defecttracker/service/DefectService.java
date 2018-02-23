package de.nordakademie.defecttracker.service;


import de.nordakademie.defecttracker.model.Defect;
import de.nordakademie.defecttracker.model.DefectChange;
import de.nordakademie.defecttracker.service.exception.DefectChangeNotAllowedException;

import java.util.List;

/**
 * Service interface for defect entities.
 *
 * @author Jan-Philipp Weber
 */
public interface DefectService {

    /**
     * Persists a given defect in the database.
     *
     * @param defect the defect to save.
     */
    void saveDefect(Defect defect);

    /**
     * Lists all defects.
     *
     * @return a list of defect entities. An empty list is returned if no defect is persisted.
     */
    List<Defect> findAllDefects();

    /**
     * Retrieves a defect by its id.
     *
     * @param id the identifier.
     * @return the found defect or {@code null} if no defect was found with the given identifier.
     */
    Defect findDefectById(Long id);

    /**
     * Lists all defects that are not closed.
     *
     * @return a list of defect entities with a status that is not {@code CLOSED}.
     * An empty list is returned if no defect that is not closed was found.
     */
    List<Defect> findAllNonClosedDefects();

    /**
     * Removes a given defect from the database.
     *
     * @param defect the defect to delete.
     */
    void deleteDefect(Defect defect);

    /**
     * Adds a given defect change to a given defect.
     *
     * @param defect       the defect to which the defect change should be added.
     * @param defectChange the defect change to add to the defect.
     * @throws DefectChangeNotAllowedException if status change is invalid or user has no permission for status change.
     */
    void addDefectChangeToDefect(Defect defect, DefectChange defectChange) throws DefectChangeNotAllowedException;
}