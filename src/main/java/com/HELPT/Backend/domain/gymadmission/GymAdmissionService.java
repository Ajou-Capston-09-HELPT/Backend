package com.HELPT.Backend.domain.gymadmission;

import com.HELPT.Backend.domain.gym.entity.Gym;
import com.HELPT.Backend.domain.gym.repository.GymRepository;
import com.HELPT.Backend.domain.member.Member;
import com.HELPT.Backend.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GymAdmissionService {

    private final MemberRepository memberRepository;
    private final GymRepository gymRepository;
    private final GymAdmissionRepository gymAdmissionRepository;

    @Transactional
    public GymAdmission addGymAdmission(Long gymId, Long userId) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        Gym gym = gymRepository.findById(gymId)
                .orElseThrow(() -> new RuntimeException("Gym not found"));
        Optional<GymAdmission> admission = gymAdmissionRepository.findByGymAndMember(gym, member);
        if(admission.isPresent()){
            return null;
        }
        GymAdmission gymAdmission = GymAdmission.builder()
                .gym(gym)
                .member(member)
                .build();
        gymAdmissionRepository.save(gymAdmission);
        return gymAdmission;
    }
}