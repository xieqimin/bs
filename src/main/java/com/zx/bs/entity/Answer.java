package com.zx.bs.entity;

import lombok.Data;


@Data
public class Answer {

    private int answer_id;
    private int question_id;
    private int user_id;
    private String answer_content;

}
