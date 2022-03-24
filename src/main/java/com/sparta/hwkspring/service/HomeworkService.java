package com.sparta.hwkspring.service;

import com.sparta.hwkspring.domain.HomeworkRequestDto;
import com.sparta.hwkspring.domain.Homework;
import com.sparta.hwkspring.domain.HomeworkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class HomeworkService {
    private final HomeworkRepository boardRepository;

    @Transactional
    public Long update(Long id, HomeworkRequestDto requestDto){
        Homework homework = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
        homework.update(requestDto);
        return homework.getId();
    }
}