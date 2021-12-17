package com.api.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seasonId;

    @OneToOne
    @JoinColumn(name = "leagueId")
    private League league;

    private Date startDate;
    private Date endDate;

    @OneToMany(mappedBy = "season", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<CricketMatch> cricketMatchList = new ArrayList<>();
}
