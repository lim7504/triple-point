package com.example.point.controller;

import com.example.point.config.ResponseResult;
import com.example.point.domain.dto.PointParam;
import com.example.point.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/point")
@RequiredArgsConstructor
public class PointController {

    private final PointService pointService;

    @PostMapping
    public ResponseEntity addPointHistory(@Validated @RequestBody PointParam pointParam) {
        this.pointService.addPointHistory(pointParam);
        return ResponseResult.ok().createResponseEntity();
    }

}
