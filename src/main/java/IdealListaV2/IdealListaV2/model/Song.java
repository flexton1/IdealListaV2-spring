package IdealListaV2.IdealListaV2.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Song {
    @Id
    @GeneratedValue(generator="uuid1")
    @GenericGenerator(name="uuid1", strategy="uuid2")
    private String musicId;
    private String musicName;   
    private String musicPosterUrl;
    private String musicUrl;
    private String musicAlbum;
    private String musicArtist;
    //ManyToMany Mapping (Many songs can be added in many user's playlist)
    @ManyToMany(mappedBy = "playlist")
    @ToString.Exclude
    private List<User> user;
    

    
    


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Song other = (Song) obj;
        if (user == null) {
            return other.user == null;
        } else return user.equals(other.user);
    }


    
}
