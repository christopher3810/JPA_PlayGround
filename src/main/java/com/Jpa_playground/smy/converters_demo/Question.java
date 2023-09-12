package com.Jpa_playground.smy.converters_demo;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.type.YesNoConverter;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {

    @Id
    private UUID id;
    private String content;
    @Convert(converter = YesNoConverter.class)
    private Boolean correctAnswer;
    private Boolean shouldBeAsked;
    private Boolean isEasy;
    private Boolean wasAskedBefore;

    // 모든 필드를 초기화하는 생성자를 만듭니다.
    @Builder
    public Question(UUID id, String content, Boolean correctAnswer, Boolean shouldBeAsked, Boolean isEasy, Boolean wasAskedBefore) {
        this.id = id;
        this.content = content;
        this.correctAnswer = correctAnswer;
        this.shouldBeAsked = shouldBeAsked;
        this.isEasy = isEasy;
        this.wasAskedBefore = wasAskedBefore;
    }
}
