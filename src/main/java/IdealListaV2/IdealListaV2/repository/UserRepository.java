package IdealListaV2.IdealListaV2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IdealListaV2.IdealListaV2.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserModelByUserId(String userId);
    Optional<List<User>> findUserModelByEnabled(Boolean status);
}
