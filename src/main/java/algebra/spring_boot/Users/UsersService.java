package algebra.spring_boot.Users;


public interface UsersService {

    Users findById (Integer id);
    Users findByUsername (String username);
}
