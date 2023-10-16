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
}
