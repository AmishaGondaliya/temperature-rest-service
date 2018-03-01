package com.temperatures.entity;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.temperatures.util.*;


@Entity
@Table(name = "temperature")
@NamedQueries({
		@NamedQuery(name = "TemperatureRepository.findAll", query = "SELECT t FROM Temperature t") , 
		@NamedQuery(name = "TemperatureRepository.findById", query = "SELECT t FROM Temperature t where t.id=:id")
		})
public class Temperature implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "TEMPERATURE")
	private Double temperature;

	@Column(nullable = false, updatable = false, name = "CREATE_DATE")
	//@Temporal(TemporalType.TIMESTAMP)
	//@Type(type="timestamp")
	@CreatedDate
	private String create_date;

	@Column(nullable = true, name = "UPDATE_DATE")
	//@Temporal(TemporalType.TIMESTAMP)
	//@Type(type="timestamp")
	@LastModifiedDate
	private String update_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	
	public Temperature() {
		
	}

	public Temperature(Long id, Double temperature, String create_date, String update_date) {
		this.id = id;
		this.temperature = temperature;
		this.create_date = create_date;
		this.update_date = update_date;
	}

	@Override
	public String toString() {
		return "Temperatures{" + "id=" + id + ", temperature='" + temperature + '\'' + ", create_date='" + create_date
				+ '\'' + ", update_date='" + update_date + '\'' + '}';
	}
}
