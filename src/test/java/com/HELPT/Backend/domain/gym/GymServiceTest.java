package com.HELPT.Backend.domain.gym;

import com.HELPT.Backend.domain.gym.dto.GymResistrationRequest;
import com.HELPT.Backend.domain.gym.dto.GymResponse;
import com.HELPT.Backend.domain.gym.entity.Gym;
import com.HELPT.Backend.domain.gym.entity.Status;
import com.HELPT.Backend.domain.gym.repository.GymRepository;
import com.HELPT.Backend.domain.manager.Manager;
import com.HELPT.Backend.domain.manager.ManagerRepository;
import com.HELPT.Backend.global.error.CustomException;
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

import static com.HELPT.Backend.global.error.ErrorCode.NOT_EXIST_DATA;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GymServiceTest {

    @Mock
    private GymRepository gymRepository;

    @Mock
    private ManagerRepository managerRepository;

    @InjectMocks
    private GymService gymService;

    private Gym gym;
    private Manager manager;

    @BeforeEach
    void setUp() {
        gym = Gym.builder()
                .id(1L)
                .gymName("Test Gym")
                .build();

        manager = Manager.builder()
                    .managerId(1L)
                    .gym(gym)
                    .build();
    }

    public GymResistrationRequest setUpGymResistrationRequest(){
        return GymResistrationRequest.builder()
                .gymName("Test Gym")
                .build();
    }

    @Test
    @DisplayName("[Service] 헬스장 등록 테스트")
    void saveGymServiceTest() {
//        // given
//        GymResistrationRequest request = setUpGymResistrationRequest();
//        given(gymRepository.save(any(Gym.class))).willReturn(gym);
//        given(managerRepository.findById(anyLong())).willReturn(Optional.of(manager));
//
//        // when
//        GymResponse response = gymService.addGym(request);
//
//        // then
//        verify(gymRepository).save(any(Gym.class));
//        verify(managerRepository).findById(anyLong());
//        assertNotNull(response);
//        assertEquals("Test Gym", response.getGymName());
    }

    @Test
    @DisplayName("[Service] 검색 키워드에 일치하는 헬스장 목록 조회 테스트")
    void findGymServiceTest() {
        // given
        given(gymRepository.findById(anyLong())).willReturn(Optional.of(gym));

        // when
        GymResponse response = gymService.findGym(1L);

        // then
        assertNotNull(response);
        verify(gymRepository).findById(1L);
        assertThat(response.getGymName()).isEqualTo(gym.getGymName());
    }

    @Test
    @DisplayName("[Service] 헬스장 정보 조회 테스트")
    void findGym_notFound() {
        // given
        given(gymRepository.findById(anyLong())).willReturn(Optional.empty());

        // when
        CustomException exception = assertThrows(CustomException.class, () -> {
            gymService.findGym(1L);
        });

        // then
        assertEquals(NOT_EXIST_DATA, exception.getErrorCode());
        verify(gymRepository).findById(1L);
    }

    @Test
    @DisplayName("[Service] 오픈채팅방 링크 조회 테스트")
    void findGyms_success() {
        // given
        List<Gym> gyms = Collections.singletonList(gym);
        given(gymRepository.findAll()).willReturn(gyms);

        // when
        List<GymResponse> responses = gymService.findGyms();

        // then
        verify(gymRepository).findAll();
        assertNotNull(responses);
        assertFalse(responses.isEmpty());
        assertThat(responses.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("[Service] 헬스장 사업자 정보 조회 테스트")
    void updateGymStatus_success() {
        // given
        given(gymRepository.findById(anyLong())).willReturn(Optional.of(gym));

        // when
        gymService.updateGymStatus(1L, Status.Approved);

        // then
        assertEquals(Status.Approved, gym.getStatus());
        verify(gymRepository).findById(1L);
        verify(gymRepository).save(gym);
    }

    @Test
    @DisplayName("[Service] 헬스장에 등록된 기구 목록 조회 테스트")
    void removeGymServiceTest() {
        // given
        given(gymRepository.findById(anyLong())).willReturn(Optional.of(gym));

        // when
        gymService.removeGym(1L);

        // then
        verify(gymRepository).findById(1L);
        verify(gymRepository).delete(any(Gym.class));
    }

    @Test
    @DisplayName("[Service] 헬스장 정보 수정 테스트")
    void a() {

    }

    @Test
    @DisplayName("[Service] 오픈채팅방 링크 변경 테스트")
    void b() {

    }

    @Test
    @DisplayName("[Service] 헬스장 삭제 테스트")
    void c() {

    }

}