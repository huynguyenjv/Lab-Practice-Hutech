package fit.hutech.huynguyen.repositories;


import fit.hutech.huynguyen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByPhone(String phone);

}