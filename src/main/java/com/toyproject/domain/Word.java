package com.toyproject.domain;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = "word", schema = "toy")
public class Word {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "word_no")
    private Integer wordNo;
    @Column
    private String word;
    @Column
    private String document;
    @Column
    private String sentence;
    @Column
    private String genre;
    @Column(name = "post_tag")
    private String postTag;
    @CreationTimestamp
    @Column(name = "reg_date")
    private Timestamp regDate;

}
