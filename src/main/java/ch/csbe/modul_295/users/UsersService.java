package ch.csbe.modul_295.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public Users saveUser(int id) {

        return usersRepository.findById(id).orElse(null);
    }
    public UserDto getUserDto(Integer id) {
        Users user = usersRepository.findById(id).orElse(null);
        if(null == user){
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(user.getAddress());
        userDto.setProfilePicture(user.getProfilePicture());
        userDto.setActive(user.getActive());
        userDto.setRole(user.getRole());
        return userDto;
    }
    public Users createUser(UserDto userDto){
        Users newUser = new Users();
        return saveUser(userDto, newUser);
    }
    public Users updateUser(int id, UserDto userDto){
        Users existingUser = usersRepository.findById(id).orElse(null);
        if (existingUser == null){
            return null;
        }
        return saveUser(userDto, existingUser);
    }

    public Users saveUser(UserDto userDto, Users existingUser) {
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setUsername(userDto.getUsername());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setAddress(userDto.getAddress());
        if (userDto.getPassword() != null){
            existingUser.setPassword(userDto.getPassword());
        }
        existingUser.setProfilePicture(userDto.getProfilePicture());
        existingUser.setActive(userDto.isActive());
        existingUser.setRole(userDto.getRole());
        return usersRepository.save(existingUser);
    }
    public void deleteUser(int id){
        usersRepository.deleteById(id);
    }
}
