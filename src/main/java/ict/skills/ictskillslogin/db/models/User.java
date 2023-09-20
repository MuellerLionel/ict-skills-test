package ict.skills.ictskillslogin.db.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "passwordHash")
    private String passwordHash;

    //mappedBy is only checked for null, so "groups" is a custom name
    @ManyToMany(mappedBy = "groups")
    Set<Group> projects = new HashSet<>();

    public User(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }
}