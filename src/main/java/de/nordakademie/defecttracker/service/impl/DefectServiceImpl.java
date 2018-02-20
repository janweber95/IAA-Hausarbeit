package de.nordakademie.defecttracker.service.impl;


import de.nordakademie.defecttracker.dao.DefectDAO;
import de.nordakademie.defecttracker.model.Defect;
import de.nordakademie.defecttracker.service.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefectServiceImpl implements DefectService {

    @Autowired
    private DefectDAO defectDAO;

    @Override
    public List<Defect> listDefects() {
        return defectDAO.findAll();
    }

    @Override
    public void saveDefect(Defect defect) {
        defectDAO.save(defect);
    }

    @Override
    public Defect findDefectById(Long id) {
        return defectDAO.findOne(id);
    }

    @Override
    public void deleteDefect(Defect defect) {
        defectDAO.delete(defect);
    }
}