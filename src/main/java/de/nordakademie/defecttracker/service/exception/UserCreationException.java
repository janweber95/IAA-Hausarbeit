package de.nordakademie.defecttracker.service.exception;


/**
 * Exception for invalid operations concerning the creation of users.
 *
 * @author Jan-Philipp Weber
 */
public class UserCreationException extends Exception {

    public UserCreationException(String message) {
        super(message);
    }
}