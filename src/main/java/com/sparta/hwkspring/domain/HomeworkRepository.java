package com.sparta.hwkspring.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework,Long> {
    List<Homework> findAllByOrderByModifiedAtDesc();
}