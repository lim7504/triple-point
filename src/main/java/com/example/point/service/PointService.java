package com.example.point.service;

import com.example.point.config.Code;
import com.example.point.config.TripleException;
import com.example.point.domain.User;
import com.example.point.domain.dto.PointParam;
import com.example.point.domain.dto.PointResult;
import com.example.point.repository.UserPointHistoryRepository;
import com.example.point.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PointService {

    private final UserPointHistoryRepository userPointHistoryRepository;
    private final UserRepository userRepository;

    @Transactional
    public void applyPoint(PointParam pointParam) {
        User user = this.getUser(pointParam.getUserId());
        user.applyPoint(pointParam);
    }

    public PointResult getPointByUser(String userId) {
        User user = this.getUser(userId);
        return user.getPointResult();
    }

    private User getUser(String userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new TripleException(Code.ACCOUNT_NOT_FOUND));
    }

}
