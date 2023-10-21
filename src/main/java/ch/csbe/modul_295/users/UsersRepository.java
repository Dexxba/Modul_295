package ch.csbe.modul_295.users;

import ch.csbe.modul_295.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {


    Optional<Users> findByUsername(String username);
}
