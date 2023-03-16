package com.call.callcenter.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "callcenter")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CallCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String from_number;

	private Date start_time;

	private Date end_time;

	private Long duration;

}
