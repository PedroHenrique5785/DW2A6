package br.edu.ifspcjo.ads.dw2a6.IFitness.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "activity")
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Enumerated(EnumType.STRING)
	private ActivityType type;
	@NotNull
	@Column(name = "activity_date")
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private LocalDate date;
	@NotNull
	private Double distance;
	@NotNull
	private Integer duration;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ActivityType getType() {
		return type;
	}
	public void setType(ActivityType type) {
		this.type = type;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setData(LocalDate date) {
		this.date = date;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		return Objects.equals(id, other.id);
	}
	
}
