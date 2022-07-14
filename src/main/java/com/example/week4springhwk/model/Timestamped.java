package com.example.week4springhwk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 이놈을 상속했을 때, 컬럼으로 인식하게 합니다.
@EntityListeners(AuditingEntityListener.class) // 반영한다 뭔가 수정이 일어났을때 생성/수정 시간을 자동으로 반영하도록 설정
public abstract class Timestamped {//abstract>>추상 직접구현이 안 되고 상속으로만 된다


    @CreatedDate // 생성일자임을 나타냅니다.
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    @JsonIgnore
    private LocalDateTime createdAt; //LocalDateTime시간을 나타내는 자료형중 하나

    @LastModifiedDate // 마지막 수정일자임을 나타냅니다.
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    private LocalDateTime modifiedAt;
}
