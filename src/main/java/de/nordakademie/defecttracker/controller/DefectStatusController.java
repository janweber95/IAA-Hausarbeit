package de.nordakademie.defecttracker.controller;


import de.nordakademie.defecttracker.model.DefectStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/defectstatus")
@Transactional(readOnly = true)
public class DefectStatusController {

    /**
     * Lists all defect status.
     *
     * @return a map consisting of each defect status and its name.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listDefectStatus() throws Exception {
        Map<DefectStatus, String> defectStatusMap = new HashMap<>();
        for (DefectStatus defectStatus : DefectStatus.values()) {
            defectStatusMap.put(defectStatus, defectStatus.getName());
        }
        return ResponseEntity.status(HttpStatus.OK).body(defectStatusMap);
    }
}