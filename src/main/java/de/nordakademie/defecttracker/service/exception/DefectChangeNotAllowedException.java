package de.nordakademie.defecttracker.service.exception;


import de.nordakademie.defecttracker.model.DefectStatus;
import de.nordakademie.defecttracker.model.User;

/**
 * Exception for invalid operations concerning the order of defect changes in defects.
 *
 * @author Jan-Philipp Weber
 */
public class DefectChangeNotAllowedException extends Exception {

    public DefectChangeNotAllowedException(User user, DefectStatus newStatus, boolean isCreator) {
        super("Der Status kann nur von dem " + (isCreator ? "Ersteller" : "Bearbeiter") + " '" + user.getUsername() +
                "' auf '" + newStatus.getName() + "' geändert werden!");
    }

    public DefectChangeNotAllowedException(DefectStatus previousStatus, DefectStatus newStatus) {
        super("Der Status kann nicht von '" + previousStatus.getName() +
                "' auf '" + newStatus.getName() + "' geändert werden!");
    }

    public DefectChangeNotAllowedException(String message) {
        super(message);
    }
}