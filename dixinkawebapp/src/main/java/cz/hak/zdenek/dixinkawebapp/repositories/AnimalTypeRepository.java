package cz.hak.zdenek.dixinkawebapp.repositories;

import cz.hak.zdenek.dixinkawebapp.domain.Animal;
import cz.hak.zdenek.dixinkawebapp.domain.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalTypeRepository extends JpaRepository<AnimalType, Long> {
}
