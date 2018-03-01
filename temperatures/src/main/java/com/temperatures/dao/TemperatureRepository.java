package com.temperatures.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.temperatures.entity.Temperature;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Long>{

	public Temperature findById(@Param("description") Long id);
}