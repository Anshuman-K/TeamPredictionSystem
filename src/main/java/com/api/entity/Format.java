package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Format")
public class Format {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int formatId;
    private String formatName;
    private boolean isLimitedOvers;
    private int overs;

    public Format(){}

    public Format(int formatId, String formatName, boolean isLimitedOvers, int overs) {
        this.formatId = formatId;
        this.formatName = formatName;
        this.isLimitedOvers = isLimitedOvers;
        this.overs = overs;
    }

    public int getFormatId() {
        return formatId;
    }

    public void setFormatId(int formatId) {
        this.formatId = formatId;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public boolean isLimitedOvers() {
        return isLimitedOvers;
    }

    public void setLimitedOvers(boolean limitedOvers) {
        isLimitedOvers = limitedOvers;
    }

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }
}
