package com.jessegreenough.ninjagoldgame.models;

public class Statement {
	private String description;
	private Boolean earned;

	public Statement() {
	}
	

	public Statement(String statement, Boolean earned) {
		super();
		this.description = statement;
		this.earned = earned;
	}


	public Boolean getEarned() {
		return earned;
	}

	public void setEarned(Boolean earned) {
		this.earned = earned;
	}

	public String getStatement() {
		return description;
	}

	public void setStatement(String statement) {
		this.description = statement;
	}
}
