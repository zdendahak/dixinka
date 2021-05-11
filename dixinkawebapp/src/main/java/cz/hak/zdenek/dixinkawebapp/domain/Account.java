package cz.hak.zdenek.dixinkawebapp.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @ManyToMany
    @JoinTable(name = "account_hobby",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id"))
    private Set<Hobby> hobbies = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Set<Animal> animals = new HashSet<>();
}
