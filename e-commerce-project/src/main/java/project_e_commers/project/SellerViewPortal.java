package project_e_commers.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seller-purchases")
@CrossOrigin(origins = "http://localhost:8080")
public class SellerViewPortal {

    @Autowired
    private PurchaseLogRepo purchaseLogRepo;

    @GetMapping
    public List<Purchase> getAllPurchases() {
        return purchaseLogRepo.findAll();
    }
}
