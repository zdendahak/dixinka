package cz.hak.zdenek.dixinkawebapp.repositories;

import cz.hak.zdenek.dixinkawebapp.domain.AnimalType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnimalTypeRepositoryIT {

    private static final String DOG = "Dog";
    private static final String FISH = "Fish";

    @Autowired
    AnimalTypeRepository animalTypeRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByNameDog() throws Exception {

        Optional<AnimalType> anTypeOptional = animalTypeRepository.findByName(DOG);

        assertEquals(DOG, anTypeOptional.get().getName());
    }

    @Test
    public void findByNameFish() throws Exception {

        Optional<AnimalType> anTypeOptional = animalTypeRepository.findByName(FISH);

        assertEquals(FISH, anTypeOptional.get().getName());
    }

}