package com.HELPT.Backend.domain.member;

import com.HELPT.Backend.domain.gym.entity.Gym;
import com.HELPT.Backend.domain.gym.entity.Status;
import com.HELPT.Backend.domain.manager.Manager;
import com.HELPT.Backend.domain.manager.dto.MemberJoinResponse;
import com.HELPT.Backend.domain.member.Dto.MemberDto;
import com.HELPT.Backend.domain.membership.Membership;
import com.HELPT.Backend.global.auth.jwt.JWTResponse;
import com.HELPT.Backend.global.auth.jwt.JWTToken;
import com.HELPT.Backend.global.auth.jwt.JWTUtil;
import com.HELPT.Backend.global.common.dto.KakaoLoginRequest;
import com.HELPT.Backend.global.common.dto.KakaoLoginResponse;
import com.HELPT.Backend.global.error.CustomException;
import com.HELPT.Backend.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final JWTUtil jwtUtil;

    @Transactional(readOnly = true)
    public JWTResponse login(KakaoLoginRequest kakaoLoginRequest) {
        Optional<Member> member = memberRepository.findByKakaoId(kakaoLoginRequest.getKakaoId());
        if(member.isEmpty()){
            throw new CustomException(ErrorCode.NOT_EXIST_USER);
        }
        JWTToken jwt = jwtUtil.createTokens(member.get().getUserId());
        return JWTResponse.builder().token(jwt).build();
    }

    @Transactional
    public JWTResponse register(MemberDto memberDto) {
        String kakaoId = memberDto.getKakaoId();
        Optional<Member> existMember = memberRepository.findByKakaoId(kakaoId);

        Member member;
        if (existMember.isPresent()) {
            member = existMember.get();
        } else {
            memberRepository.save(memberDto.toEntity());
            member = memberRepository.findByKakaoId(kakaoId).orElseThrow(() -> new RuntimeException("Manager could not be retrieved after save."));
        }

        JWTToken jwt = jwtUtil.createTokens(member.getUserId());
        return JWTResponse.builder().token(jwt).build();
    }


    public boolean attendance(Long userId)
    {
        Membership membership =  memberRepository.attendance(userId);
        if(membership==null) return false;
        membership.attend();

        return true;
    }

    @Transactional(readOnly = true)
    public MemberDto findMember(Long userId)
    {
        Member member = memberRepository.findById(userId).orElseThrow(() -> new RuntimeException("Member not found"));
        MemberDto memberDto = MemberDto.toDto(member);
        return memberDto;
    }

    @Transactional(readOnly = true)
    public List<MemberJoinResponse> searchMembersByGymAndName(Long gymId, String name) {
        return memberRepository.memberList(gymId, name);
    }

    @Transactional
    public MemberDto updateMember(Long userId,MemberDto member)
    {
        Member findMember = memberRepository.findById(userId).orElseThrow(() -> new RuntimeException("Member not found"));
        findMember.setHeight(member.getHeight());
        findMember.setWeight(member.getWeight());
        MemberDto resultDto = MemberDto.toDto(findMember);

        return resultDto;
    }

    @Transactional
    public void removeMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Gym not found"));
        memberRepository.delete(member);
    }
}
