package project_e_commers.project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseLogRepo extends JpaRepository<Purchase, Long> {
    List<Purchase> findByProductId(Long productId);
}
