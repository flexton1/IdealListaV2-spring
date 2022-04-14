package IdealListaV2.IdealListaV2.model;



import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Likke {
    // private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="uuid1")
    @GenericGenerator(name="uuid1", strategy="uuid2")
    private String UId;
    private Integer noOfLike=0;

    //ManyToMany Mapping (Many users can give like to many songs)
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        joinColumns = { @JoinColumn(name = "userId") }, 
        inverseJoinColumns = { @JoinColumn(name = "likeUId") }
    )
    private List<User> likedUser;
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((likedUser == null) ? 0 : likedUser.hashCode());
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
        Likke other = (Likke) obj;
        if (likedUser == null) {
            return other.likedUser == null;
        } else return likedUser.equals(other.likedUser);
    }

}
