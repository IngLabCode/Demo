package project_e_commers.project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageVaultRepo extends JpaRepository<ContactMessage, Long> {
}
