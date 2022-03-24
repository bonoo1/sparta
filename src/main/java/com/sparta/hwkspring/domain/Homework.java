package com.sparta.hwkspring.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Homework extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String text;

    public Homework(HomeworkRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.text = requestDto.getText();
    }

    public void update(HomeworkRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.text = requestDto.getText();
    }
}