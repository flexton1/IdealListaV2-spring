package IdealListaV2.IdealListaV2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import IdealListaV2.IdealListaV2.dto.AuthenticationResponse;
import IdealListaV2.IdealListaV2.dto.LoginRequest;
import IdealListaV2.IdealListaV2.dto.RefreshTokenRequest;
import IdealListaV2.IdealListaV2.dto.RegistrationRequest;
import IdealListaV2.IdealListaV2.service.AuthService;
import IdealListaV2.IdealListaV2.service.RefreshTokenService;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegistrationRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity<>("Registracija korisnika uspješna",
                OK);
    }

    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Račun uspješno aktiviran", OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/refresh/token")
    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(OK).body("Refresh Token Deleted Successfully!!");
    }
}