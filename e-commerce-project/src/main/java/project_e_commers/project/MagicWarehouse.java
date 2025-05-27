package project_e_commers.project;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MagicWarehouse extends JpaRepository<ShopItem, Long> {
    List<ShopItem> findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(String name, String category);
}
