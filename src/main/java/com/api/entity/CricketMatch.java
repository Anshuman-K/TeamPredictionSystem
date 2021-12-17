package com.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class CricketMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cricketMatchId;

    @ManyToOne
    @JsonBackReference
    private Season season;

    private String venue;
    private Date date;
    private String location;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(name = "Team_CricketMatch",joinColumns = @JoinColumn(name = "cricketMatch_Id"), inverseJoinColumns = @JoinColumn(name = "team_Id"))
    private List<Team> teams = new ArrayList<>();
}
