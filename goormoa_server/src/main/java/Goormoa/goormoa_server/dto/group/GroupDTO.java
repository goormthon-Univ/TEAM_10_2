package Goormoa.goormoa_server.dto.group;

import Goormoa.goormoa_server.entity.category.Category;
import Goormoa.goormoa_server.dto.user.UserInfoDTO;
import Goormoa.goormoa_server.dto.user.UserDTO;
import Goormoa.goormoa_server.dto.profile.ProfileDetailDTO;


import Goormoa.goormoa_server.entity.group.Group;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GroupDTO {
    private Long groupId;
    private UserInfoDTO host;
    private Category category;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date closeDate;
    private String groupTitle;
    private String groupInfo;
    private Integer maxCount;
    private Integer currentCount;
    private Boolean close;
    private UserInfoDTO userInfoDTO;

    public GroupDTO(Group group, UserInfoDTO userInfoDTO) {
        this.groupId = group.getGroupId();
        this.closeDate = group.getCloseDate();
        this.groupTitle = group.getGroupTitle();
        this.groupInfo = group.getGroupInfo();
        this.maxCount = group.getMaxCount();
        this.currentCount = group.getCurrentCount();
        this.userInfoDTO = userInfoDTO;
    }
}
