package com.example.point.controller;

import com.example.point.config.ResponseResult;
import com.example.point.domain.dto.PointParam;
import com.example.point.domain.dto.PointResult;
import com.example.point.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/point")
@RequiredArgsConstructor
public class PointController {

    private final PointService pointService;

    @PostMapping
    public ResponseEntity applyPoint(@Validated @RequestBody PointParam pointParam) {
        this.pointService.applyPoint(pointParam);
        return ResponseResult.ok().createResponseEntity();
    }

    @GetMapping("/users/{user-id}")
    public ResponseEntity getPointByUser(@PathVariable("user-id") String userId) {
        PointResult pointByUser = this.pointService.getPointByUser(userId);
        return ResponseResult.ok(pointByUser).createResponseEntity();
    }
}
