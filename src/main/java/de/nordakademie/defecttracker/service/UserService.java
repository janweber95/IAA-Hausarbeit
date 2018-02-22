package de.nordakademie.defecttracker.service;


import de.nordakademie.defecttracker.model.User;

public interface UserService {

    /**
     * Persists a given user in the database.
     *
     * @param user the user to save.
     * @return the persisted user.
     */
    User saveUser(User user);

    /**
     * Retrieves a user by its username.
     *
     * @param username the identifier.
     * @return the found user or {@code null} if no user was found with the given identifier.
     */
    User findUserByUsername(String username);
}