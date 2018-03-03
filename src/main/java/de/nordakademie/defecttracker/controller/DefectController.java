package de.nordakademie.defecttracker.controller;


import de.nordakademie.defecttracker.model.Defect;
import de.nordakademie.defecttracker.model.DefectChange;
import de.nordakademie.defecttracker.service.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Controller for defect entities.
 *
 * @author Jan-Philipp Weber
 */
@RestController
@RequestMapping("/defects")
@Transactional
public class DefectController {

    @Autowired
    private DefectService defectService;

    /**
     * Lists all defects.
     *
     * @param excludeClosed specifies, if only defects that are not closed should be returned.
     * @return a list of defect entities. An empty list is returned if no defect is persisted.
     */
    @RequestMapping(method = GET)
    public List<Defect> listDefects(@RequestParam(value = "excludeclosed", required = false) boolean excludeClosed) {
        return excludeClosed ? defectService.findAllNonClosedDefects() : defectService.findAllDefects();
    }

    /**
     * Persists a given defect in the database.
     *
     * @param defect the defect to save.
     * @return status CREATED or BAD_REQUEST if the defect already exists or saving failed.
     */
    @RequestMapping(method = POST)
    public ResponseEntity saveDefect(@RequestBody Defect defect) {
        try {
            defectService.saveDefect(defect);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Removes a defect from the database.
     *
     * @param id the of the defect to delete.
     * @return status OK or NOT_FOUND if the defect does not exist.
     */
    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity deleteDefect(@PathVariable Long id) {
        Defect defect = defectService.findDefectById(id);
        if (defect != null) {
            defectService.deleteDefect(defect);
            return ResponseEntity.status(OK).build();
        }
        return ResponseEntity.status(NOT_FOUND).build();
    }

    /**
     * Add a defect change to a defect.
     *
     * @param id           the id of the defect where the defect change should be added.
     * @param defectChange the defect change to add.
     * @return return OK, BAD_REQUEST if adding was not possible or NOT_FOUND if no defect was found with given id.
     */
    @RequestMapping(value = "/{id}", method = POST)
    public ResponseEntity addDefectChange(@PathVariable Long id, @RequestBody DefectChange defectChange) {
        Defect defect = defectService.findDefectById(id);
        if (defect != null) {
            try {
                defectService.addDefectChangeToDefect(defect, defectChange);
                return ResponseEntity.status(OK).build();
            } catch (Exception e) {
                return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
            }
        }
        return ResponseEntity.status(NOT_FOUND).build();
    }
}