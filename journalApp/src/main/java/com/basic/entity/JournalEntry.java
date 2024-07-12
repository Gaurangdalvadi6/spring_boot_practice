package com.basic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @NonNull
    private String title;

    @NonNull
    private String content;

    private LocalDateTime date;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "journalentry_id")
    private User user;
}
