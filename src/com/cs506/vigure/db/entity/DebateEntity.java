package com.cs506.vigure.db.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="debate_model")
public class DebateEntity { // this represents the debate_model table in the db

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;

	@Column(name="title")
	private String title;
	
	@Column(name="topic")
	private String topic;
	
	@Column(name="status")
	private int status;
	
	@Column(name="instigatorNum")
	private long instigatorNum;
	
	@Column(name="defenderNum")
	private long defenderNum;
	
	@Column(name="startTime")
	private Date startTime;
	
	@Column(name="timeInterval")
	private int timeInterval;
	
	@Column(name="rounds")
	private int rounds;
	
	public DebateEntity(){}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(int timeInterval) {
		this.timeInterval = timeInterval;
	}
	
	public int getRounds() {
		return this.rounds;
	}
	
	public void setRounds(int rounds) {
		this.rounds = rounds;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
