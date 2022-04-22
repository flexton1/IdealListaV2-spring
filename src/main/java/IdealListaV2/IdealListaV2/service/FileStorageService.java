package IdealListaV2.IdealListaV2.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import IdealListaV2.IdealListaV2.model.FileDB;
import IdealListaV2.IdealListaV2.model.ProfilePicFile;
import IdealListaV2.IdealListaV2.repository.FileDBRepository;
import IdealListaV2.IdealListaV2.repository.ProfilePicRepository;

@Service
public class FileStorageService {
  @Autowired
  private FileDBRepository fileDBRepository;
  @Autowired
  private ProfilePicRepository pictureRepository;
 
 
  public FileDB store(MultipartFile file, String playlist) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(), playlist);
    // songService.addMusic(FileDB, fileName); dont work
    return fileDBRepository.save(FileDB);
  }
  public FileDB getFile(String id) {
    return fileDBRepository.findById(id).get();
  }
  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }



  public ProfilePicFile getPicture(String userName){
    return pictureRepository.findByUserName(userName).get();
  }

  public ProfilePicFile storePicture(MultipartFile file, String userName) throws IOException {
    if(pictureRepository.findByUserName(userName).isPresent()){
      pictureRepository.delete(pictureRepository.findByUserName(userName).get());
    }

    ProfilePicFile FileDB = new ProfilePicFile(file.getContentType(), file.getBytes(), userName);
    return pictureRepository.save(FileDB);
    
  }

}
    

