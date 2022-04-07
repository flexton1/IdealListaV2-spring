package IdealListaV2.IdealListaV2.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import IdealListaV2.IdealListaV2.model.Song;
import IdealListaV2.IdealListaV2.model.User;
import IdealListaV2.IdealListaV2.service.SongService;
import IdealListaV2.IdealListaV2.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class PlaylistController {
    private final UserService userService;
    private final SongService songService;
    
    //Get User Playlist
    @GetMapping("/playlist/{id}")
    public Set<Song> getUserPlaylist(@PathVariable(value="id") String id){
        User user = userService.findById(id);
        if(user !=null){
            Set<Song> musicList = user.getPlaylist();
            return musicList;
        }
        return null;
    }

    //Add to playlist
    @PostMapping("/addtoplaylist/{id}/{musicId}")
    public Set<Song> addSongToPlaylist(@PathVariable(value="id") String id, @PathVariable(value="musicId") String musicId){
        User user = userService.findById(id);
        Song music = songService.findById(musicId);
        
        Set<Song> pList = user.getPlaylist();
        pList.add(music);
        user.setPlaylist(pList);
        userService.updateUser(user);
        return pList;
    }

    //Remove from playlist
    @DeleteMapping("/removefromplaylist/{id}/{musicId}")
    public void removeSongFromPlaylist(@PathVariable(value="id") String id, @PathVariable(value="musicId") String musicId){
        User user = userService.findById(id);
        Song music = songService.findById(musicId);
        Set<Song> pList = user.getPlaylist();
        if(pList.contains(music))
        {
            pList.remove(music);
        }
        user.setPlaylist(pList);
        userService.updateUser(user);
    }
}
