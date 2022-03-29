package IdealListaV2.IdealListaV2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IdealListaV2.IdealListaV2.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
}
