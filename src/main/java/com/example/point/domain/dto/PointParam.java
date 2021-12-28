package com.example.point.domain.dto;

import com.example.point.domain.PointType;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
public class PointParam {

    @Size(min = 36, max = 36)
    private String userId;

    private PointType pointType;

    private String reason;

    @Min(0)
    private Integer point;

}
