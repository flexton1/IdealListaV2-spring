package IdealListaV2.IdealListaV2.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IdealListaV2.IdealListaV2.exceptions.GenericResponse;
import IdealListaV2.IdealListaV2.model.Song;
import IdealListaV2.IdealListaV2.service.SongService;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/songs")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SongController {
    private final SongService musicService;
  
  

   //Get all songs for admin
   @GetMapping("/admin/music ")
   public GenericResponse<List<Song>> getAllMusic(@Param("keyword") String keyword){
       List<Song> musicList = musicService.allMusic(keyword);
       GenericResponse<List<Song>> response = new GenericResponse<>();
       response.setResponse(musicList);
       return response;
   }

   //Get a particular song by id
   @GetMapping("/admin/music/{id}")
   public Song getMusicById(@PathVariable(value="id") String id){
       Song music = musicService.findById(id);
       return music;
 }

   //Get all songs for user
   @GetMapping("/music ")
   public List<Song> getAllMovieList(@Param("keyword") String keyword){
       List<Song> musicList = musicService.allMusic(keyword);
       return musicList;
   }

   //Update a song by id
   @PutMapping("/admin/music/{id}")
   public Song musicUpdate(@RequestBody Song music, @PathVariable String id){
       music.setMusicId(id);
       Song musicN = musicService.updateMusic(music);
       return musicN;

   }
   //Delete a song by id
   @DeleteMapping("/admin/music/{id}")
   public void musicDelete(@PathVariable String id){
       musicService.deleteMusic(id);
   }

  

   
    
}
