package project_e_commers.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:8080")
public class WhisperReceiver {

    @Autowired
    private MessageVaultRepo messageRepo;

    @PostMapping
    public String receiveMessage(@RequestBody ContactMessage message) {
        messageRepo.save(message);
        return "Message received! We'll get back to you soon.";
    }
}
