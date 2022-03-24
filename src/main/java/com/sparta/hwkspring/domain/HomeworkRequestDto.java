package com.sparta.hwkspring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HomeworkRequestDto {
    private String title;
    private String name;
    private String text;
}