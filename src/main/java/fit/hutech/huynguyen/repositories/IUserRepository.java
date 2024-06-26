package fit.hutech.huynguyen.repositories;

import fit.hutech.huynguyen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    Optional<Object> findByEmail(String email);

    Optional<Object> findByPhone(String phone);
}