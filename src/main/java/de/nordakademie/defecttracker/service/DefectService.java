package de.nordakademie.defecttracker.service;


import de.nordakademie.defecttracker.model.Defect;

import java.util.List;

public interface DefectService {

    /**
     * Lists all defects.
     *
     * @return a list of defect entities. An empty list is returned if no defect is persisted.
     */
    List<Defect> listDefects();

    /**
     * Persists a given defect in the database.
     *
     * @param defect the defect to save.
     */
    void saveDefect(Defect defect);

    /**
     * Retrieves a defect by its id.
     *
     * @param id the identifier.
     * @return the found defect or {@code null} if no defect was found with the given identifier.
     */
    Defect findDefectById(Long id);

    /**
     * Removes a given defect from the database.
     *
     * @param defect the defect to delete.
     */
    void deleteDefect(Defect defect);
}