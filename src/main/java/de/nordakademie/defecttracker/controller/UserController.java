package de.nordakademie.defecttracker.controller;


import de.nordakademie.defecttracker.model.User;
import de.nordakademie.defecttracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/users")
@Transactional
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = POST)
    public ResponseEntity login(@RequestBody User user) {
        User persistedUser = userService.findUserByUsername(user.getUsername());
        if (persistedUser == null || !persistedUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
        return ResponseEntity.status(OK).body(persistedUser);
    }
}