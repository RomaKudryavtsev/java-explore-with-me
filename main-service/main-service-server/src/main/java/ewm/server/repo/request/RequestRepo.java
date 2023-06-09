package ewm.server.repo.request;

import ewm.server.model.request.ParticipationRequest;
import ewm.server.model.request.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepo extends JpaRepository<ParticipationRequest, Long>,
        QuerydslPredicateExecutor<ParticipationRequest> {
    List<ParticipationRequest> findAllByRequestStatusAndEvent_EventId(RequestStatus requestStatus, Long eventId);

    Optional<ParticipationRequest> findByRequester_UserIdAndEvent_EventId(Long requesterId, Long eventId);
}
