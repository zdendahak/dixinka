package cz.hak.zdenek.dixinkawebapp.repositories;

import cz.hak.zdenek.dixinkawebapp.domain.Animal;
import cz.hak.zdenek.dixinkawebapp.domain.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalTypeRepository extends JpaRepository<AnimalType, Long> {

    Optional<AnimalType> findByName(String name);

}
