package foe.fuelpass.qr_code_scanning_service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/qr-scan")
@RequiredArgsConstructor
public class QrCodeScanningController {

    @PostMapping("/validate")
    public ResponseEntity<String> validateQrCode(@RequestParam String qrCode) {
        // For simplicity, we'll assume the QR code is just the vehicle ID for now
        return ResponseEntity.ok("Vehicle ID associated with QR code: " + qrCode);
    }
}