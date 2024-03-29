package com.HELPT.Backend.domain.member.Dto;

import com.HELPT.Backend.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

    private Long userId;

    private Long gymId;

    private String userName;

    private String gender;

    private float height;

    private float weight;


    public MemberDto(Long userId, Long gymId, String userName, String gender, float height, float weight) {
        this.userId = userId;
        this.gymId = gymId;
        this.userName = userName;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }
    public Member toEntity()
    {
        return Member.builder()
                .gymId(gymId)
                .userName(userName)
                .gender(gender)
                .height(height)
                .weight(weight)
                .build();
    }

    public static MemberDto toDto(Member member)
    {
        return new MemberDto(member.getUserId(),member.getGymId(),member.getUserName(),member.getGender(),member.getHeight(),member.getWeight());
    }
}
