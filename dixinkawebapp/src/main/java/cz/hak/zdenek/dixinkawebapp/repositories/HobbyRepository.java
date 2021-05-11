package cz.hak.zdenek.dixinkawebapp.repositories;

import cz.hak.zdenek.dixinkawebapp.domain.Account;
import cz.hak.zdenek.dixinkawebapp.domain.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
}
