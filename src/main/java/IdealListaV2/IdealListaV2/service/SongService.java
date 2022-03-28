package IdealListaV2.IdealListaV2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import IdealListaV2.IdealListaV2.model.Song;
import IdealListaV2.IdealListaV2.repository.SongRepository;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class SongService {
    private final SongRepository musicRepo;

    public Song addMusic(Song music){
        Song newMusic = musicRepo.save(music);
		return newMusic;
    }

    public List<Song> allMusic(String keyword){
		if(keyword!=null){
			return musicRepo.findByMusicNameContainingIgnoreCase(keyword);
		}
        List<Song> musicList = musicRepo.findAll();
		return musicList;
    }

    public Song findById(String id){
		Song music = musicRepo.findById(id).orElse(null);
		return music;
	}

    public Song updateMusic(Song musicModel){
		Song music = musicRepo.save(musicModel);
		return music;
	}

	public void deleteMusic(String id){
		musicRepo.deleteById(id);
	}

}
