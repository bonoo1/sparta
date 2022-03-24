package com.sparta.hwkspring.controller;
import com.sparta.hwkspring.domain.Homework;
import com.sparta.hwkspring.domain.HomeworkRepository;
import com.sparta.hwkspring.domain.HomeworkRequestDto;
import com.sparta.hwkspring.service.HomeworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeworkController {
    private final HomeworkRepository homeworkRepository;
    private final HomeworkService homeworkService;

    @PostMapping("/api/homeworks")
    public Homework createBoard(@RequestBody HomeworkRequestDto requestDto){
        Homework homework = new Homework(requestDto);
        return homeworkRepository.save(homework);
    }

    @GetMapping("/api/homeworks")
    public List<Homework> getBoard(){
        return homeworkRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/homeworks/{id}")
    public Long deleteBoard(@PathVariable Long id){
        homeworkRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/homeworks/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody HomeworkRequestDto requestDto){
        return homeworkService.update(id, requestDto);
    }
}