package algebra.spring_boot.Users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService{

    private final UsersRepository usersRepository;


    @Override
    public Users findById(Integer id) {
        Optional<Users> user = usersRepository.findById(id);

        if (user.isEmpty()) {
            throw new RuntimeException("User not found.");
        }

        return user.get();
    }

    @Override
    public Users findByUsername(String username) {
        Optional<Users> user = usersRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new RuntimeException("User not found.");
        }

        return user.get();
    }
}
