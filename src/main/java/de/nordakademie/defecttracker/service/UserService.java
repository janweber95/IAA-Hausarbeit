package de.nordakademie.defecttracker.service;


import de.nordakademie.defecttracker.model.User;
import de.nordakademie.defecttracker.service.exception.UserCreationException;

/**
 * Service interface for user entities.
 *
 * @author Jan-Philipp Weber
 */
public interface UserService {

    /**
     * Persists a given user in the database.
     *
     * @param user the user to save.
     * @return the persisted user.
     */
    User saveUser(User user) throws UserCreationException;

    /**
     * Retrieves a user by its username.
     *
     * @param username the identifier.
     * @return the found user or {@code null} if no user was found with the given identifier.
     */
    User findUserByUsername(String username);
}