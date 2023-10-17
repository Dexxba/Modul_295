package ch.csbe.modul_295.users;

import ch.csbe.modul_295.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public Users getUsers(int id) {

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
        userDto.setProfilePicture(user.getProfilePicture());
        userDto.setActive(user.getActive());
        userDto.setRole(user.getRole());
        return userDto;
    }
}
