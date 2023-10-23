package ch.csbe.modul_295.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * This class represents a service for managing users.
 */
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * Retrieves a user with the specified ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user with the specified ID, or null if not found.
     */
    public Users saveUser(int id) {
        // Find a user by ID in the repository or return null if not found
        return usersRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves user information in a Data Transfer Object (DTO) format.
     *
     * @param id The ID of the user to retrieve.
     * @return A UserDto containing user information, or null if the user is not found.
     */
    public UserDto getUserDto(Integer id) {
        Users user = usersRepository.findById(id).orElse(null);
        if (null == user) {
            return null;
        }
        // Create a UserDto and populate it with user information
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(user.getAddress());
        userDto.setProfilePicture(user.getProfilePicture());
        userDto.setActive(user.getActive());
        userDto.setAdmin(user.isAdmin());
        return userDto;
    }

    /**
     * Creates a new user.
     *
     * @param userDto The UserDto containing user information.
     * @return The newly created user.
     */
    public Users createUser(UserDto userDto) {
        // Create a new User instance
        Users newUser = new Users();
        return saveUser(userDto, newUser);
    }

    /**
     * Updates an existing user with the specified ID.
     *
     * @param id     The ID of the user to update.
     * @param userDto The UserDto containing updated user information.
     * @return The updated user, or null if the user is not found.
     */
    public Users updateUser(int id, UserDto userDto) {
        // Find an existing user by ID or return null if not found
        Users existingUser = usersRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return null;
        }
        return saveUser(userDto, existingUser);
    }

    /**
     * Saves user information from a UserDto to an existing user.
     *
     * @param userDto       The UserDto containing updated user information.
     * @param existingUser  The existing user to update.
     * @return The updated user.
     */
    public Users saveUser(UserDto userDto, Users existingUser) {
        // Update the existing user with information from the UserDto
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setUsername(userDto.getUsername());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setAddress(userDto.getAddress());
        // Check if a new password is provided in the UserDto. If not null, update the user's password.
        if (userDto.getPassword() != null) {
            // If a password is provided in the UserDto, encrypt and set it
            existingUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        }
        existingUser.setProfilePicture(userDto.getProfilePicture());
        existingUser.setActive(userDto.isActive());
        existingUser.setAdmin(userDto.isAdmin());
        // Save the updated user in the repository
        return usersRepository.save(existingUser);
    }

    /**
     * Deletes a user with the specified ID.
     *
     * @param id The ID of the user to delete.
     */
    public void deleteUser(int id) {
        // Delete a user by ID from the repository
        usersRepository.deleteById(id);
    }
}
