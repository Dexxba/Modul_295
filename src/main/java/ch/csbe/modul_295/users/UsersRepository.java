package ch.csbe.modul_295.users;

import ch.csbe.modul_295.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * The CategoryRepository interface defines data access operations for the Users entity.
 * It extends JpaRepository, which provides basic CRUD (Create, Read, Update, Delete) functionality.
 *
 * @param <Users> The entity type this repository manages.
 * @param <Integer> The type of the primary key of the entity.
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    /**
     * Find a user by their username.
     *
     * @param username The username of the user to find.
     * @return An Optional containing the User with the specified username if found, or an empty Optional if not found.
     */
    Optional<Users> findByUsername(String username);
}
