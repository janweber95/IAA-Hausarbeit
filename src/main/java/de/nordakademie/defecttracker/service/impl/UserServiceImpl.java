package de.nordakademie.defecttracker.service.impl;


import de.nordakademie.defecttracker.dao.UserDAO;
import de.nordakademie.defecttracker.model.User;
import de.nordakademie.defecttracker.service.UserService;
import de.nordakademie.defecttracker.service.exception.UserCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service implementation for user entities.
 *
 * @author Jan-Philipp Weber
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User saveUser(User user) throws UserCreationException {
        String username = user.getUsername();
        User existingUser = findUserByUsername(username);
        if (existingUser != null) {
            throw new UserCreationException("Es existiert bereits ein Benutzer mit dem Benutzername '" + username + "'!");
        }
        String email = user.getEmail();
        existingUser = userDAO.findByEmail(email);
        if (existingUser != null) {
            throw new UserCreationException("Es existiert bereits ein Benutzer mit der E-Mail-Adresse '" + email + "'!");
        }
        return userDAO.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDAO.findByUsername(username);
    }
}