package Goormoa.goormoa_server.dto.alarm;

import Goormoa.goormoa_server.dto.follow.FollowDTO;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FollowAlarmDTO {
//    private Long userId;
//    private String content; // 알람 내용
//    private AlarmType alarmType;
//    private Follow follow;
    private FollowDTO followDTO;
}
