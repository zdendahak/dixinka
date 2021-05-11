package cz.hak.zdenek.dixinkawebapp.repositories;

import cz.hak.zdenek.dixinkawebapp.domain.Animal;
import cz.hak.zdenek.dixinkawebapp.domain.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
