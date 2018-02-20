package de.nordakademie.defecttracker.service;


import de.nordakademie.defecttracker.model.User;

public interface UserService {

    /**
     * Retrieves a user by its username.
     *
     * @param username the identifier.
     * @return the found user or {@code null} if no user was found with the given identifier.
     */
    User findUserByUsername(String username);
}