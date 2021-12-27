package com.example.point.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User extends CreatedModifiedAuditing {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private Integer point;

    public void updatePoint(PointType pointType, Integer point) {
        if(PointType.ADD.equals(pointType)) {
            point += point;
        } else {
            point -= point;
        }
    }
}
