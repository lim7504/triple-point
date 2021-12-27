package com.example.point.domain;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class UserPointHistory extends CreatedModifiedAuditing {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String userId;

    private PointType type;

    private String reason;

    private Integer point;

    public static UserPointHistory createUserPointHistory(String userId, PointType type, String reason, Integer point) {
        UserPointHistory newUserPointHistory = new UserPointHistory();
        newUserPointHistory.userId = userId;
        newUserPointHistory.type = type;
        newUserPointHistory.reason = reason;
        newUserPointHistory.point = point;
        return newUserPointHistory;
    }
}
