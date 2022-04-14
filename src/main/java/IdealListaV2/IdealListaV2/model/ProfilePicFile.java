package IdealListaV2.IdealListaV2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "profilePictures")
public class ProfilePicFile {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;
  private String type;
  private String userName;
  @Lob
  private byte[] data;
  public ProfilePicFile() {
  }
  public ProfilePicFile(String type, byte[] data, String userName) {
   this.userName = userName;
    this.type = type;
    this.data = data;
  }
  public String getId() {
    return id;
  }
  
 
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public byte[] getData() {
    return data;
  }
  public void setData(byte[] data) {
    this.data = data;
  }
  public String getUserName(){
      return this.userName;
  }
  public void setUsername(String userName){
      this.userName = userName;
  }
}
