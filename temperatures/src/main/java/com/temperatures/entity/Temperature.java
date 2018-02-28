package com.temperatures.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


@Entity
@Table(name = "temperature")
//@NamedQueries(value = {
//		@NamedQuery(name = "TemperatureRepository.findAll", query = "SELECT t FROM Temperature") , 
//		@NamedQuery(name = "TemperatureRepository.findById", query = "SELECT t FROM Temperature t where t.id=:id")
//		})
public class Temperature {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "TEMPERATURE")
	private Double temperature;

	@Column(nullable = false, updatable = false, name = "CREATE_DATE")
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date create_date;

	@Column(nullable = true, name = "UPDATE_DATE")
	@Temporal(TemporalType.DATE)
	@LastModifiedDate
	private Date update_date;

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

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
	public Temperature() {
		
	}

	public Temperature(Long id, Double temperature, Date create_date, Date update_date) {
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
