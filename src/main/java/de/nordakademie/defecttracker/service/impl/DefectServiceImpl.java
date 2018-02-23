package de.nordakademie.defecttracker.service.impl;


import de.nordakademie.defecttracker.dao.DefectDAO;
import de.nordakademie.defecttracker.model.Defect;
import de.nordakademie.defecttracker.model.DefectChange;
import de.nordakademie.defecttracker.model.DefectStatus;
import de.nordakademie.defecttracker.model.User;
import de.nordakademie.defecttracker.service.exception.DefectChangeNotAllowedException;
import de.nordakademie.defecttracker.service.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static de.nordakademie.defecttracker.model.DefectStatus.*;

/**
 * Service implementation for defect entities.
 *
 * @author Jan-Philipp Weber
 */
@Service
@Transactional
public class DefectServiceImpl implements DefectService {

    @Autowired
    private DefectDAO defectDAO;

    @Override
    public void saveDefect(Defect defect) {
        defectDAO.save(defect);
    }

    @Override
    public List<Defect> findAllDefects() {
        return defectDAO.findAll();
    }

    @Override
    public List<Defect> findAllNonClosedDefects() {
        return defectDAO.findAllNonClosed();
    }

    @Override
    public Defect findDefectById(Long id) {
        return defectDAO.findOne(id);
    }

    @Override
    public void deleteDefect(Defect defect) {
        defectDAO.delete(defect);
    }

    @Override
    public void addDefectChangeToDefect(Defect defect, DefectChange defectChange) throws DefectChangeNotAllowedException {
        defectChange.setPreviousStatus(defect.getStatus());
        checkIfChangeIsValid(defect, defectChange);
        defect.addDefectChange(defectChange);
        defect.setStatus(defectChange.getNewStatus());
        saveDefect(defect);
    }

    private void checkIfChangeIsValid(Defect defect, DefectChange defectChange) throws DefectChangeNotAllowedException {
        DefectStatus defectStatus = defect.getStatus();
        DefectStatus newStatus = defectChange.getNewStatus();
        if (defectStatus == newStatus) {
            throw new DefectChangeNotAllowedException(defectStatus, newStatus);
        } else if (defectStatus == CREATED || defectStatus == REOPENED) {
            if (newStatus != IN_PROCESS) {
                throw new DefectChangeNotAllowedException(defectStatus, newStatus);
            }
        } else if (defectStatus == IN_PROCESS) {
            if (newStatus != REJECTED && newStatus != RESOLVED) {
                throw new DefectChangeNotAllowedException(defectStatus, newStatus);
            }
            User lastEditor = getLastEditor(defect);
            if (!defectChange.getEditor().equals(lastEditor)) {
                throw new DefectChangeNotAllowedException(lastEditor, newStatus, false);
            }
        } else if (defectStatus == REJECTED || defectStatus == RESOLVED) {
            if (newStatus != RESOLVED && newStatus != CLOSED) {
                throw new DefectChangeNotAllowedException(defectStatus, newStatus);
            }
            User defectCreator = defect.getCreator();
            if (!defectChange.getEditor().equals(defectCreator)) {
                throw new DefectChangeNotAllowedException(defectCreator, newStatus, true);
            }
        } else if (defectStatus == CLOSED) {
            throw new DefectChangeNotAllowedException("Der Status eines Tickets mit dem Status '" + CLOSED.getName()
                + "' kann nicht mehr verändert werden!");
        }
    }

    private User getLastEditor(Defect defect) {
        List<DefectChange> changes = defect.getChanges();
        return changes.get(changes.size()-1).getEditor();
    }
}