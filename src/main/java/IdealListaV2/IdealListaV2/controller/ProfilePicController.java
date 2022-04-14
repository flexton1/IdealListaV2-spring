package IdealListaV2.IdealListaV2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import IdealListaV2.IdealListaV2.message.ResponseMessage;
import IdealListaV2.IdealListaV2.model.ProfilePicFile;
import IdealListaV2.IdealListaV2.service.FileStorageService;

@Controller
@RequestMapping("/api/profileImages")
@CrossOrigin("*")
public class ProfilePicController {
    @Autowired
    private FileStorageService storageService;

    @GetMapping("/{userName)")
    public ResponseEntity<byte[]> getProfilePic(@PathVariable String userName){
        ProfilePicFile fileDB = storageService.getPicture(userName);
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getId() + "\"")
            .body(fileDB.getData());
      }

      @PostMapping("/upload/{userName}")
      public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,
  @PathVariable String userName) {
    String message = "";
    try {
      storageService.storePicture(file, userName);
      message = "Uploaded the profile picture successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the profile picture: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }
    }


