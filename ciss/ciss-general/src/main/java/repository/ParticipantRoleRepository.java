package repository;

import domain.participant.ParticipantRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRoleRepository extends JpaRepository<ParticipantRole, String> {

    ParticipantRole findParticipantRoleByName(String name);
}
