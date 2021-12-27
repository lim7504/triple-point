package com.example.point.repository;

import com.example.point.domain.UserPointHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPointHistoryRepository extends JpaRepository<UserPointHistory, String> {
}
