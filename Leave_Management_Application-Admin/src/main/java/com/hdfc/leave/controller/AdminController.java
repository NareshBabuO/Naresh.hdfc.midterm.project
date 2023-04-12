package com.hdfc.leave.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.hdfc.leave.DTO.LeaveRequestDTO;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Project/Admin")
public class AdminController {

	String url = "http://localhost:8118/Project/leaveRequest";

	@PutMapping("/update")
	public Mono<String> updateRequest(@RequestBody LeaveRequestDTO lRequestDTO) {
		WebClient webClient = WebClient.create(url);
		Mono<String> mono = webClient.put().uri("/Update").body(Mono.just(lRequestDTO), LeaveRequestDTO.class)
				.retrieve().bodyToMono(String.class);
		return mono;
	}

	/*
	 * @PutMapping("/Update") public LeaveRequests updateRequest(@RequestBody
	 * LeaveRequestDTO lRequestDTO) { return service.updateRequest(lRequestDTO);
	 * 
	 * }
	 */
}
