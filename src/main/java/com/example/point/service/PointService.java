package com.example.point.service;

import com.example.point.config.Code;
import com.example.point.config.TripleException;
import com.example.point.domain.User;
import com.example.point.domain.UserPointHistory;
import com.example.point.domain.dto.PointParam;
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
    public void addPointHistory(PointParam pointParam) {
        UserPointHistory userPointHistory =  UserPointHistory.createUserPointHistory(pointParam.getUserId(), pointParam.getPointType(), pointParam.getReason(), pointParam.getPoint());
        this.userPointHistoryRepository.save(userPointHistory);

        User user = this.getUser(pointParam);
        user.updatePoint(pointParam.getPointType(), pointParam.getPoint());
    }

    private User getUser(PointParam pointParam) {
        return this.userRepository.findById(pointParam.getUserId())
                .orElseThrow(() -> new TripleException(Code.ACCOUNT_NOT_FOUND));
    }
}
