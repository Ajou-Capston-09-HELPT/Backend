//package com.HELPT.Backend.domain.gymequipment;
//
//import com.HELPT.Backend.domain.equipment.Equipment;
//import com.HELPT.Backend.domain.equipment.EquipmentRepository;
//import com.HELPT.Backend.domain.gymequipment.dto.GymEquipmentRequest;
//import com.HELPT.Backend.domain.gymequipment.dto.GymEquipmentResponse;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class GymEquipmentServiceTest {
//
//    @InjectMocks
//    private GymEquipmentService gymEquipmentService;
//
//    @Mock
//    private GymEquipmentRepository gymEquipmentRepository;
//
//    @Mock
//    private EquipmentRepository equipmentRepository;
//
//    public Equipment setUpGymEquipment(){
//        return Equipment.builder()
//                .equipmentId(1L)
//                .exerciseId(100L)
//                .equipmentName("벤치 프레스")
//                .defaultCount(10)
//                .defaultSet(5)
//                .defaultWeight(25)
//                .build();
//    }
//
//    @Test
//    @DisplayName("[Service] 기구 생성 서비스 테스트")
//    public void saveGymEquipmentServiceTest() {
//        GymEquipmentRequest request = new GymEquipmentRequest(/* set properties */);
//        GymEquipment gymEquipment = request.toEntity();
//        GymEquipment savedEquipment = new GymEquipment(/* set properties */);
//
//        when(gymEquipmentRepository.save(any(GymEquipment.class))).thenReturn(savedEquipment);
//
//        GymEquipmentResponse result = gymEquipmentService.addGymEquipment(request);
//
//        assertNotNull(result);
//        // Assert various properties of the result based on the savedEquipment
//        assertEquals(savedEquipment.getId(), result.getId());
//        // more assertions
//    }
//
//}