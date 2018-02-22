package de.nordakademie.defecttracker.service.impl;


import de.nordakademie.defecttracker.dao.UserDAO;
import de.nordakademie.defecttracker.model.User;
import de.nordakademie.defecttracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User saveUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDAO.findByUsername(username);
    }

}