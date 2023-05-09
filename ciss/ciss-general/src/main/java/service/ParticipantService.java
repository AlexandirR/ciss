package service;

import domain.User;
import domain.participant.Applicant;
import domain.participant.ParticipantRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ParticipantRepository;
import repository.ParticipantRoleRepository;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private ParticipantRoleRepository participantRoleRepository;

    public Applicant createApplicantByUser(User user) {
        Applicant applicant = (Applicant) participantRepository.findParticipantByUserIdAndRoleName(user.getId(),
                ParticipantRole.Names.APPLICANT);
        if (applicant != null) {
            return applicant;
        }
        applicant = new Applicant();
        applicant.setUser(user);
        applicant.setRole(participantRoleRepository.findParticipantRoleByName(ParticipantRole.Names.APPLICANT));
        return participantRepository.save(applicant);
    }
}
