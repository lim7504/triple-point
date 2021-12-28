package com.example.point.domain;

import com.example.point.domain.dto.PointParam;
import com.example.point.domain.dto.PointResult;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
public class User extends CreatedModifiedAuditing {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private Integer point;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserPointHistory> userPointHistories = new ArrayList<>();

    // 포인트 적용
    public void applyPoint(PointParam pointParam) {
        if(PointType.ADD.equals(pointParam.getPointType())) {
            this.point += pointParam.getPoint();
        } else if (PointType.DELETE.equals(pointParam.getPointType())) {
            this.point -= pointParam.getPoint();
        }
        UserPointHistory userPointHistory =  UserPointHistory.createUserPointHistory(this, pointParam.getPointType(), pointParam.getReason(), pointParam.getPoint(), this.point);
        this.userPointHistories.add(userPointHistory);
    }

    public PointResult getPointResult() {
        List<String> logs = this.getUserPointHistories().stream()
                .sorted(Comparator.comparing(UserPointHistory::getCreatedDate).reversed())
                .map(UserPointHistory::getLog)
                .collect(Collectors.toList());
        return PointResult.createPointResult(this.id, this.point, logs);
    }
}
