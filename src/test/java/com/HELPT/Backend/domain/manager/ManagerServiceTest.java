package com.HELPT.Backend.domain.manager;

import com.HELPT.Backend.global.common.dto.KakaoLoginRequest;
import com.HELPT.Backend.domain.manager.dto.ManagerRequest;
import com.HELPT.Backend.domain.manager.dto.ManagerResponse;
import com.HELPT.Backend.domain.member.Dto.MemberJoinResponse;
import com.HELPT.Backend.global.auth.jwt.JWTResponse;
import com.HELPT.Backend.global.auth.jwt.JWTToken;
import com.HELPT.Backend.global.auth.jwt.JWTUtil;
import com.HELPT.Backend.global.error.CustomException;
import com.HELPT.Backend.global.error.ErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ManagerServiceTest {

    @InjectMocks
    private ManagerService managerService;

    @Mock
    private ManagerRepository managerRepository;

    @Mock
    private JWTUtil jwtUtil;

    private Manager manager;
    private ManagerRequest managerRequest;
    private JWTToken jwtToken;

    @BeforeEach
    void setUp() {
        manager = Manager.builder()
                .managerId(1L)
                .kakaoId("kakao123")
                .build();

        managerRequest = ManagerRequest.builder()
                .kakaoId("kakao123")
                .build();

        jwtToken = JWTToken.builder()
                .accessToken("access_token")
                .refreshToken("refresh_token")
                .build();
    }

    @Test
    @DisplayName("[Service] 소셜 로그인 테스트")
    void registerServiceTest() {
//        // given
//        given(managerRepository.findByKakaoId(anyString())).willReturn(Optional.empty());
//        given(managerRepository.save(any(Manager.class))).willReturn(manager);
//        given(jwtUtil.createTokens(anyLong())).willReturn(jwtToken);
//
//        // when
//        JWTResponse response = managerService.register(managerRequest);
//
//        // then
//        verify(managerRepository).findByKakaoId(anyString());
//        verify(managerRepository).save(any(Manager.class));
//        verify(jwtUtil).createTokens(anyLong());
//        assertNotNull(response);
//        assertThat(response.getToken().getAccessToken()).isEqualTo(jwtToken.getAccessToken());
    }

    @Test
    @DisplayName("[Service] 헬스장 관리자 로그인 테스트")
    void loginServiceTest() {
//        // given
//        KakaoLoginRequest request = new KakaoLoginRequest("kakao123", "device_token");
//        given(managerRepository.findByKakaoId(anyString())).willReturn(Optional.of(manager));
//        given(jwtUtil.createTokens(anyLong())).willReturn(jwtToken);
//
//        // when
//        JWTResponse response = managerService.login(request);
//
//        // then
//        verify(managerRepository).findByKakaoId(anyString());
//        verify(jwtUtil).createTokens(anyLong());
//        assertNotNull(response);
//        assertThat(response.getToken().getAccessToken()).isEqualTo(jwtToken.getAccessToken());
    }

    @Test
    @DisplayName("[Service] 헬스장 관리자 회원 가입 테스트")
    void findManagerServiceTest() {
//        // given
//        given(managerRepository.findById(anyLong())).willReturn(Optional.of(manager));
//
//        // when
//        ManagerResponse response = managerService.findManager(1L);
//
//        // then
//        verify(managerRepository).findById(anyLong());
//        assertNotNull(response);
//        assertThat(response.getManagerId()).isEqualTo(manager.getManagerId());
    }

    @Test
    @DisplayName("[Service] 헬스장 관리자 로그아웃 테스트")
    void findManagersServiceTest() {
//        // given
//        List<Manager> managers = Collections.singletonList(manager);
//        given(managerRepository.findAll()).willReturn(managers);
//
//        // when
//        List<ManagerResponse> responses = managerService.findManagers();
//
//        // then
//        verify(managerRepository).findAll();
//        assertNotNull(responses);
//        assertFalse(responses.isEmpty());
//        assertThat(responses.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("[Service] 헬스장 관리자 회원탈퇴 테스트")
    void modifyManagerServiceTest() {
//        // given
//        given(managerRepository.findById(anyLong())).willReturn(Optional.of(manager));
//
//        // when
//        ManagerResponse response = managerService.modifyManager(1L, managerRequest);
//
//        // then
//        verify(managerRepository).findById(anyLong());
//        assertNotNull(response);
//        assertThat(response.getManagerId()).isEqualTo(manager.getManagerId());
    }

//    @Test
//    @DisplayName("[Service] Manager 삭제 테스트")
//    void removeManagerServiceTest() {
//        // given
//        given(managerRepository.findById(anyLong())).willReturn(Optional.of(manager));
//
//        // when
//        managerService.removeManager(1L);
//
//        // then
//        verify(managerRepository).findById(anyLong());
//        verify(managerRepository).delete(any(Manager.class));
//    }

//    @Test
//    @DisplayName("[Service] 특정 헬스장의 회원 목록 조회 테스트")
//    void memberListServiceTest() {
////        // given
////        List<MemberJoinResponse> members = List.of(new MemberJoinResponse());
////        given(managerRepository.MemberList(anyLong())).willReturn(members);
////
////        // when
////        List<MemberJoinResponse> result = managerService.memberList(1L);
////
////        // then
////        verify(managerRepository).MemberList(anyLong());
////        assertNotNull(result);
////        assertFalse(result.isEmpty());
//    }
}