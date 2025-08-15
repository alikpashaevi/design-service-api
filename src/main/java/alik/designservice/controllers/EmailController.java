package alik.designservice.controllers;

import alik.designservice.service.EmailService;
import alik.designservice.service.EmailVerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailVerificationService verificationService;

    @PostMapping("/send-code")
    public ResponseEntity<String> sendCode(@RequestParam String email) {
        verificationService.sendVerificationCode(email);
        return ResponseEntity.ok("Verification code sent to " + email);
    }

    @PostMapping("/verify-code")
    public ResponseEntity<String> verifyCode(@RequestParam String email, @RequestParam String code) {
        boolean verified = verificationService.verifyCode(email, code);
        return verified
                ? ResponseEntity.ok("Email verified successfully!")
                : ResponseEntity.badRequest().body("Invalid or expired verification code");
    }

}
