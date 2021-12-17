package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ipldata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int matchId;
    private int inning;
    private int over_num;
    private int ball;
    private String batsman;
    private String non_striker;
    private String bowler;
    private int batsman_runs;
    private int extra_runs;
    private int total_runs;
    private int non_boundary;
    private int is_wicket;
    private String dismissal_kind;
    private String player_dismissed;
    private String fielder;
    private String extras_type;
    private String batting_team;
    private String bowling_team;
}
