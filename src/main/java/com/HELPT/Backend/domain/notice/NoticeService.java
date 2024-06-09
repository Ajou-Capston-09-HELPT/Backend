package com.HELPT.Backend.domain.notice;

import com.HELPT.Backend.domain.emitter.EmitterService;
import com.HELPT.Backend.domain.emitter.entity.NotificationType;
import com.HELPT.Backend.domain.member.Member;
import com.HELPT.Backend.domain.member.MemberRepository;
import com.HELPT.Backend.domain.notice.dto.NoticeRequest;
import com.HELPT.Backend.domain.notice.dto.NoticeResponse;
import com.HELPT.Backend.global.error.CustomException;
import com.HELPT.Backend.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final MemberRepository memberRepository;
    private final EmitterService emitterService;

    public List<NoticeResponse> findNotice(Long gymId)
    {
        List<Notice> noticeList = noticeRepository.findAllByGymId(gymId).orElseThrow(() -> new CustomException(ErrorCode.NOT_EXIST_USER));

        return noticeList.stream().map(NoticeResponse::new).toList();
    }

    public Boolean uploadNotice(NoticeRequest noticeRequest)
    {
        Notice newNotice = Notice.builder()
                .gymId(noticeRequest.getGymId())
                .title(noticeRequest.getTitle())
                .content(noticeRequest.getContent())
                .createAt(noticeRequest.getCreateAt())
                .build();

        Notice notice = noticeRepository.save(newNotice);
        List<Member> members = memberRepository.findAllByGymId(noticeRequest.getGymId());
        String url = "/notices/" + notice.getNoticeId();
        String content = notice.getTitle();

        for (Member member : members) {
            log.info(member.getUserName());
            emitterService.send(member, content, NotificationType.NOTICE, url);
        }
        return Boolean.TRUE;
    }

    public Boolean deleteNotice(Long noticeId)
    {
        noticeRepository.deleteById(noticeId);

        return Boolean.TRUE;
    }

    public Boolean modifyNotice(Long noticeId, NoticeRequest noticeRequest)
    {
        String newTitle = noticeRequest.getTitle();
        String newContent = noticeRequest.getContent();

        Notice findNotice = noticeRepository.findById(noticeId).orElseThrow(() -> new CustomException(ErrorCode.NOT_EXIST_USER));

        findNotice.setTitle(newTitle);
        findNotice.setContent(newContent);

        return Boolean.TRUE;
    }

}
