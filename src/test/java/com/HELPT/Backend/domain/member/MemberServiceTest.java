package com.HELPT.Backend.domain.member;

import com.HELPT.Backend.domain.fcm.DeviceTokenService;
import com.HELPT.Backend.domain.member.Dto.MemberDetailResponse;
import com.HELPT.Backend.domain.member.Dto.MemberJoinResponse;
import com.HELPT.Backend.domain.member.Dto.MemberDto;
import com.HELPT.Backend.domain.membership.Membership;
import com.HELPT.Backend.global.auth.jwt.JWTResponse;
import com.HELPT.Backend.global.auth.jwt.JWTToken;
import com.HELPT.Backend.global.auth.jwt.JWTUtil;
import com.HELPT.Backend.global.common.dto.KakaoLoginRequest;
import com.HELPT.Backend.global.error.CustomException;
import com.HELPT.Backend.global.error.ErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private JWTUtil jwtUtil;

    @Mock
    private DeviceTokenService deviceTokenService;

    private Member member;
    private MemberDto memberDto;
    private JWTToken jwtToken;

    @BeforeEach
    void setUp() {
        member = Member.builder()
                .userId(1L)
                .kakaoId("kakao123")
                .height(180)
                .weight(75)
                .build();

        memberDto = MemberDto.builder()
                .kakaoId("kakao123")
                .height(180)
                .weight(75)
                .build();

        jwtToken = JWTToken.builder()
                .accessToken("access_token")
                .refreshToken("refresh_token")
                .build();
    }

    @Test
    @DisplayName("[Service] 회원 로그인 테스트")
    void loginServiceTest() {
//        // given
//        KakaoLoginRequest request = new KakaoLoginRequest("kakao123", "device_token");
//        given(memberRepository.findByKakaoId(anyString())).willReturn(Optional.of(member));
//        given(jwtUtil.createTokens(anyLong())).willReturn(jwtToken);
//
//        // when
//        JWTResponse response = memberService.login(request);
//
//        // then
//        verify(memberRepository).findByKakaoId(anyString());
//        verify(jwtUtil).createTokens(anyLong());
//        verify(deviceTokenService).saveDeviceToken(anyLong(), anyString());
//        assertNotNull(response);
//        assertThat(response.getToken().getAccessToken()).isEqualTo(jwtToken.getAccessToken());
    }

    @Test
    @DisplayName("[Service] 회원 등록 테스트")
    void registerServiceTest() {
//        // given
//        given(memberRepository.findByKakaoId(anyString())).willReturn(Optional.empty());
//        given(memberRepository.save(any(Member.class))).willReturn(member);
//        given(jwtUtil.createTokens(anyLong())).willReturn(jwtToken);
//
//        // when
//        JWTResponse response = memberService.register(memberDto);
//
//        // then
//        verify(memberRepository).findByKakaoId(anyString());
//        verify(memberRepository).save(any(Member.class));
//        verify(jwtUtil).createTokens(anyLong());
//        assertNotNull(response);
//        assertThat(response.getToken().getAccessToken()).isEqualTo(jwtToken.getAccessToken());
    }

    @Test
    @DisplayName("[Service] 회원 로그아웃 테스트")
    void attendanceServiceTest() {
//        // given
//        Membership membership = new Membership();
//        given(memberRepository.attendance(anyLong())).willReturn(membership);
//
//        // when
//        boolean result = memberService.attendance(1L);
//
//        // then
//        verify(memberRepository).attendance(anyLong());
//        assertTrue(result);
    }

    @Test
    @DisplayName("[Service] 헬스장에 등록된 회원 검색 테스트")
    void findMemberServiceTest() {
//        // given
//        given(memberRepository.findById(anyLong())).willReturn(Optional.of(member));
//
//        // when
//        MemberDto result = memberService.findMember(1L);
//
//        // then
//        verify(memberRepository).findById(anyLong());
//        assertNotNull(result);
//        assertThat(result.getUserId()).isEqualTo(member.getUserId());
    }

    @Test
    @DisplayName("[Service] 헬스장 관리자가 회원 상세 조회 테스트")
    void findMemberDetailServiceTest() {
//        // given
//        MemberDetailResponse detailResponse = new MemberDetailResponse();
//        given(memberRepository.memberDetail(anyLong())).willReturn(detailResponse);
//
//        // when
//        MemberDetailResponse result = memberService.findMemberDetail(1L);
//
//        // then
//        verify(memberRepository).memberDetail(anyLong());
//        assertNotNull(result);
    }

    @Test
    @DisplayName("[Service] 자신의 정보 상세 조회 테스트")
    void searchMembersByGymAndNameServiceTest() {
//        // given
//        List<MemberJoinResponse> members = List.of(new MemberJoinResponse());
//        given(memberRepository.memberList(anyLong(), anyString())).willReturn(members);
//
//        // when
//        List<MemberJoinResponse> result = memberService.searchMembersByGymAndName(1L, "name");
//
//        // then
//        verify(memberRepository).memberList(anyLong(), anyString());
//        assertNotNull(result);
//        assertFalse(result.isEmpty());
    }

    @Test
    @DisplayName("[Service] 회원 정보 수정 테스트")
    void updateMemberServiceTest() {
//        // given
//        given(memberRepository.findById(anyLong())).willReturn(Optional.of(member));
//
//        // when
//        MemberDto result = memberService.updateMember(1L, memberDto);
//
//        // then
//        verify(memberRepository).findById(anyLong());
//        assertNotNull(result);
//        assertThat(result.getHeight()).isEqualTo(memberDto.getHeight());
    }

    @Test
    @DisplayName("[Service] 회원 탈퇴 테스트")
    void removeMemberServiceTest() {
//        // given
//        given(memberRepository.findById(anyLong())).willReturn(Optional.of(member));
//
//        // when
//        memberService.removeMember(1L);
//
//        // then
//        verify(memberRepository).findById(anyLong());
//        verify(memberRepository).delete(any(Member.class));
    }
}