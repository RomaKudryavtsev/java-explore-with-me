package ewm.server.repo.event;

import ewm.server.model.request.ParticipationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo extends JpaRepository<ParticipationRequest, Long> {
}
