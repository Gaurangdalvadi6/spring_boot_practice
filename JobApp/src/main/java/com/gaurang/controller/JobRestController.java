package com.gaurang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaurang.model.JobPost;
import com.gaurang.service.JobService;

@RestController
public class JobRestController {
	@Autowired
	JobService jobservice;
	
	@GetMapping("/jobPosts")
	public List<JobPost> getAllJobs() {
		return jobservice.getAllJobs();
	}
	@PostMapping("/cc")
	public void addJobs(@RequestBody JobPost post) {
		jobservice.addJobPost(post);;
	}
}
