package igor_dev.CrmEvolution.repository;

import igor_dev.CrmEvolution.model.Leads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadsRepository extends JpaRepository<Leads, Long> {
}
