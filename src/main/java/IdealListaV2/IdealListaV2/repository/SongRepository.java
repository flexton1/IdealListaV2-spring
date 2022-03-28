package IdealListaV2.IdealListaV2.repository;


import IdealListaV2.IdealListaV2.model.Song;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, String> {
    List<Song> findByMusicNameContainingIgnoreCase(String keyword);
   
}
