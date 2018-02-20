package de.nordakademie.defecttracker.dao;


import de.nordakademie.defecttracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}