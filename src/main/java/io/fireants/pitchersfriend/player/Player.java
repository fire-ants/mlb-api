package io.fireants.pitchersfriend.player;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Player implements Serializable {

	private static final long serialVersionUID = 123610794124658L;

	private Integer id;
	private String firstName;
	private String lastName;
	private String position;
	private String bats;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date birthDate;
	private String height;
	private String weight;
	private String team;

	public Player(){}

	public Player(Integer id, String firstName, String lastName, String position, String bats, Date birthDate,
			String height, String weight, String team) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.bats = bats;
		this.birthDate = birthDate;
		this.height = height;
		this.weight = weight;
		this.team = team;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getBats() {
		return bats;
	}
	public void setBats(String bats) {
		this.bats = bats;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
}

