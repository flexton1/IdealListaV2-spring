package IdealListaV2.IdealListaV2.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid2")
    private String userId;
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    private Instant created;
    private boolean enabled;
    private String mobileNumber;

    private String role;
    private String question;
    private String answer;
    
    //ManyToMany Mapping (Many users can give like to many songs)
    @ManyToMany(mappedBy = "likedUser")
    @ToString.Exclude
    private List<Like> like; 
    //ManyToMany Mapping (Many users can add to playlist many songs)
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "UserMusic", 
        joinColumns = { @JoinColumn(name = "userId") }, 
        inverseJoinColumns = { @JoinColumn(name = "musicId") }
    )
    @ToString.Exclude
    private Set<Song> playlist;
    
    
   public String getId() {
        return userId;
    }

    public void setId(String id) {
        this.userId = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Boolean getActive() {
        return enabled;
    }

    public void setActive(Boolean active) {
        this.enabled = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public Set<Song> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Set<Song> playlist) {
        this.playlist = playlist;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return userId != null && Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
    

