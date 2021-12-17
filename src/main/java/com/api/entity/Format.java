package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Format")
public class Format {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int formatId;
    private String formatName;
    private boolean isLimitedOvers;
    private int overs;
}
