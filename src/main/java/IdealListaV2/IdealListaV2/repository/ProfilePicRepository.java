package IdealListaV2.IdealListaV2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IdealListaV2.IdealListaV2.model.ProfilePicFile;

@Repository
public interface ProfilePicRepository extends JpaRepository<ProfilePicFile, String> {
    Optional<ProfilePicFile> findByUserName(String userName);
}
