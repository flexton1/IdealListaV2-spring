package IdealListaV2.IdealListaV2.service;

import java.util.List;


import org.springframework.stereotype.Service;

import IdealListaV2.IdealListaV2.model.FileDB;
import IdealListaV2.IdealListaV2.model.Song;
import IdealListaV2.IdealListaV2.repository.SongRepository;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class SongService {
    private final SongRepository musicRepo;

	//dont work
    // public Song addMusic(FileDB music, String fileName){
	// 	Song song = new Song();
	// 	song.musicName = fileName;
	// 	Song newMusic = musicRepo.save(song);
	// 	return newMusic;
    // }

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
