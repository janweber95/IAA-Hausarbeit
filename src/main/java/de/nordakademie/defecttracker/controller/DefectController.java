package de.nordakademie.defecttracker.controller;


import de.nordakademie.defecttracker.model.Defect;
import de.nordakademie.defecttracker.model.DefectChange;
import de.nordakademie.defecttracker.service.exception.DefectChangeNotAllowedException;
import de.nordakademie.defecttracker.service.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/defects")
@Transactional
public class DefectController {

    @Autowired
    private DefectService defectService;

    /**
     * Lists all defects.
     *
     * @return a list of defect entities. An empty list is returned if no defect is persisted.
     */
    @RequestMapping(method = GET)
    public List<Defect> listDefects() {
        return defectService.listDefects();
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
            return ResponseEntity.status(BAD_REQUEST).build();
        }
    }

    /**
     * Updates a given defect in the database.
     *
     * @param defect the defect to update.
     * @param id the id of the defect to update.
     * @return status NO_CONTENT or BAD_REQUEST if the defect does not exist or saving failed.
     */
    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity updateDefect(@RequestBody Defect defect, @PathVariable Long id) {
        if (defectService.findDefectById(id) != null && defect.getId().equals(id)) {
            try {
                defectService.saveDefect(defect);
                return ResponseEntity.status(NO_CONTENT).build();
            } catch (Exception e) {
                return ResponseEntity.status(BAD_REQUEST).build();
            }
        }
        return ResponseEntity.status(BAD_REQUEST).build();
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

    @RequestMapping(value = "/{id}", method = POST)
    public ResponseEntity addDefectChange(@PathVariable Long id, @RequestBody DefectChange defectChange) {
        Defect defect = defectService.findDefectById(id);
        if (defect != null) {
            try {
                defectService.addDefectChangeToDefect(defect, defectChange);
                return ResponseEntity.status(OK).build();
            } catch (DefectChangeNotAllowedException e) {
                return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
            }
        }
        return ResponseEntity.status(NOT_FOUND).build();
    }
}