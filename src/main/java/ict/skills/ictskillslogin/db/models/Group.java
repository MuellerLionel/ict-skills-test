package ict.skills.ictskillslogin.db.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
@NoArgsConstructor
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "groupname")
    private String groupname;
    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "ueser_belongsto_group",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "group_id") }
    )
    Set<User> users = new HashSet<>();

    public Group(String groupname, String description) {
        this.groupname = groupname;
        this.description = description;
    }
}