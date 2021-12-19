package com.api.entity;


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

	public void setLimitedOvers(boolean isLimitedOvers) {
		this.isLimitedOvers = isLimitedOvers;
	}

	public int getOvers() {
		return overs;
	}

	public void setOvers(int overs) {
		this.overs = overs;
	}

	@Override
	public String toString() {
		return "Format [formatId=" + formatId + ", formatName=" + formatName + ", isLimitedOvers=" + isLimitedOvers
				+ ", overs=" + overs + "]";
	}
	
	public Format () {
		
	}
	
	public Format(int formatId, String formatName, boolean isLimitedOvers, int overs) {
		super();
		this.formatId = formatId;
		this.formatName = formatName;
		this.isLimitedOvers = isLimitedOvers;
		this.overs = overs;
	}
	
}
