package project_e_commers.project;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin(origins = "*")
public class OrderController {

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Map<String, Object> orderData) {
        System.out.println("Order received: " + orderData);
        return ResponseEntity.ok("Order received successfully!");
    }
}
