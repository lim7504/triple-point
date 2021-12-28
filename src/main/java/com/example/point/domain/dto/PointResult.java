package com.example.point.domain.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PointResult {

    private String userId;

    private Integer accumulatedPoint;

    private List<String> logs = new ArrayList<>();

    public static PointResult createPointResult(String userId, Integer accumulatedPoint, List<String> logs) {
        PointResult newPointResult = new PointResult();
        newPointResult.userId = userId;
        newPointResult.accumulatedPoint = accumulatedPoint;
        newPointResult.logs = logs;
        return newPointResult;
    }
}
