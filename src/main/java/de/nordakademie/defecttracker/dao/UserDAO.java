package de.nordakademie.defecttracker.dao;


import de.nordakademie.defecttracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO for user entities.
 *
 * @author Jan-Philipp Weber
 */
public interface UserDAO extends JpaRepository<User, Long> {

    /**
     * Retrieves a user by its username.
     *
     * @param username the identifier.
     * @return the found user or {@code null} if no user was found with the given identifier.
     */
    User findByUsername(String username);
}