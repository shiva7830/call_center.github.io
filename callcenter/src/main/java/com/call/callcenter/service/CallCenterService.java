package com.call.callcenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.call.callcenter.repository.CallCenterRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CallCenterService {

	@Autowired
	CallCenterRepository callCenterRepository;

	public String findCallValumeHighestHours() {
		String result = callCenterRepository.findCallValumeHighestHours();
		return result;
	}

	public String findLongestCallHours() {
		String result = callCenterRepository.findLongestCallHours();
		return result;
	}

	public String findCallValumeHighestDays() {
		String result = callCenterRepository.findCallValumeHighestDays();
		return result;
	}

	public String findLongestCallDays() {
		String result = callCenterRepository.findLongestCallDays();
		return result;
	}
}
