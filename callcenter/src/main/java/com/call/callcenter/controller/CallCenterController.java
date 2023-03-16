package com.call.callcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.call.callcenter.service.CallCenterService;

@RestController
@RequestMapping("/callcenters")
public class CallCenterController {

	@Autowired
	CallCenterService callCenterService;

	@GetMapping("/findHighestDayVolume")
	public String findCallValumeHighestHours() {
		return callCenterService.findCallValumeHighestHours();
	}

	@GetMapping("/findLongestCallHours")
	public String findLongestCallHours() {
		return callCenterService.findLongestCallHours();
	}

	@GetMapping("/findCallValumeHighestDays")
	public String findCallValumeHighestDays() {
		return callCenterService.findCallValumeHighestDays();
	}

	@GetMapping("/findLongestCallDays")
	public String findLongestCallDays() {
		return callCenterService.findLongestCallDays();
	}
}
