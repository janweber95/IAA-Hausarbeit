package de.nordakademie.defecttracker.model;


import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * User entity.
 *
 * @author Jan-Philipp Weber
 */
@Entity
public class User {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userIdGenerator"
    )
    @SequenceGenerator(
            name = "userIdGenerator",
            initialValue = 1000
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NaturalId
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "FULL_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username != null ? username.equals(user.username) : user.username == null;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }
}