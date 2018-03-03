package de.nordakademie.defecttracker.controller;


import de.nordakademie.defecttracker.model.User;
import de.nordakademie.defecttracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Controller for user entities.
 *
 * @author Jan-Philipp Weber
 */
@RestController
@RequestMapping("/users")
@Transactional
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Checks if transmitted user data is valid (= login).
     *
     * @param user the user to check.
     * @return OK or NOT_FOUND if user date is invalid.
     */
    @RequestMapping(value = "/login", method = POST)
    public ResponseEntity login(@RequestBody User user) {
        User existingUser = userService.findUserByUsername(user.getUsername());
        boolean validLoginData = existingUser != null && existingUser.getPassword().equals(user.getPassword());
        return validLoginData ? ResponseEntity.status(OK).body(existingUser) : ResponseEntity.status(NOT_FOUND).build();
    }

    /**
     * Persists a given user in the database.
     *
     * @param user the user to save.
     * @return status CREATED or BAD_REQUEST if a user with the same username already exists.
     */
    @RequestMapping(method = POST)
    public ResponseEntity createUser(@RequestBody User user) {
        try {
            User createdUser = userService.saveUser(user);
            return ResponseEntity.status(CREATED).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
        }
    }
}