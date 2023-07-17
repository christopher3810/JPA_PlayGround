package com.Jpa_playground.smy.convertersDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
public class Question {

    @Id
    private UUID id;
    private String content;
    private Boolean correctAnswer;
    private Boolean shouldBeAsked;
    private Boolean isEasy;
    private Boolean wasAskedBefore;

    public Question(){

    }

}
