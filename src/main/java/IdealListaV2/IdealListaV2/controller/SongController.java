package IdealListaV2.IdealListaV2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IdealListaV2.IdealListaV2.repository.SongRepository;
import IdealListaV2.IdealListaV2.service.StorageService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/songs")
@AllArgsConstructor
public class SongController {

    private final StorageService storageService;
    private final SongRepository songRepository;


    // @GetMapping
    // public ResponseEntity<?> getSongs(){
    //     return new ResponseEntity.ok()
    // }
    
}
