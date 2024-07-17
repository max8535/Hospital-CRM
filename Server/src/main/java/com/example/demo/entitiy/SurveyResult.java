package com.example.demo.entitiy;

import jakarta.persistence.*;

@Entity
public class SurveyResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @OneToOne
    @JoinColumn(name = "schedule_survey_id")
    private ScheduleSurvey scheduleSurvey;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ScheduleSurvey getScheduleSurvey() {
        return scheduleSurvey;
    }
}
