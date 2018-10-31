package com.cs506.vigure.Models;

import java.sql.Time;

import org.springframework.stereotype.Component;

@Component
public class Debate {

	private String topic;
	private String status;
	private long instigatorNum;
	private long defenderNum;
	private Time startTime;
	private int timeInterval;
	private long debateID;
	
	public String getTopic() {
		return topic;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public long getInstigatorNum() {
		return instigatorNum;
	}
	
	public void setInstigatorNum(long instigatorNum) {
		this.instigatorNum = instigatorNum;
	}
	
	public long getDefenderNum() {
		return defenderNum;
	}
	
	public void setDefenderNum(long defenderNum) {
		this.defenderNum = defenderNum;
	}
	
	public Time getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	
	public int getTimeInterval() {
		return timeInterval;
	}
	
	public void setTimeInterval(int timeInterval) {
		this.timeInterval = timeInterval;
	}
	
	public long getDebateID() {
		return debateID;
	}
	
	public void setDebateID(long debateID) {
		this.debateID = debateID;
	}
	
}
