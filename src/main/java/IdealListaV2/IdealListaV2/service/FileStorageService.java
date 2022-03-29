package IdealListaV2.IdealListaV2.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import IdealListaV2.IdealListaV2.model.FileDB;
import IdealListaV2.IdealListaV2.repository.FileDBRepository;

@Service
public class FileStorageService {
  @Autowired
  private FileDBRepository fileDBRepository;
  private SongService songService;
  public FileDB store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
    // songService.addMusic(FileDB, fileName); dont work
    return fileDBRepository.save(FileDB);
  }
  public FileDB getFile(String id) {
    return fileDBRepository.findById(id).get();
  }
  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
}
    

