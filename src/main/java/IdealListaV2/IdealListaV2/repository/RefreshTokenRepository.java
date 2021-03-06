package IdealListaV2.IdealListaV2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import IdealListaV2.IdealListaV2.model.RefreshToken;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    void deleteByToken(String token);
}