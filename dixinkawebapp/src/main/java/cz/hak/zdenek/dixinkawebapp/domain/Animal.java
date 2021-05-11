package cz.hak.zdenek.dixinkawebapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Lob
    private Byte[] image;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private AnimalType animalType;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
