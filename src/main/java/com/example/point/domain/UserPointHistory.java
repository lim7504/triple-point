package com.example.point.domain;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
public class UserPointHistory extends CreatedModifiedAuditing {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private PointType type;

    private String reason;

    private Integer applyPoint;

    private Integer accumulatedPoint;

    public static UserPointHistory createUserPointHistory(User user, PointType type, String reason, Integer applyPoint, Integer accumulatedPoint) {
        UserPointHistory newUserPointHistory = new UserPointHistory();
        newUserPointHistory.user = user;
        newUserPointHistory.type = type;
        newUserPointHistory.reason = reason;
        newUserPointHistory.applyPoint = applyPoint;
        newUserPointHistory.accumulatedPoint = accumulatedPoint;
        return newUserPointHistory;
    }

    public String getLog() {
        return "type=" + type +
                ", applyPoint=" + applyPoint +
                ", accumulatedPoint=" + accumulatedPoint +
                ", reason='" + reason + '\'';
    }
}
