package com.example.point.domain.dto;

import com.example.point.domain.PointType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
public class PointParam {

    private String userId;
    private PointType pointType;
    private String reason;
    private Integer point;

}
