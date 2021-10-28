package com.br.comicapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.br.comicapi.model.JumpIssue;
import com.br.comicapi.service.JumpService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class JumpController {

    Logger logger = LoggerFactory.getLogger(JumpController.class);
	
	@Autowired
	private JumpService jumpService;

	@CrossOrigin
	@PostMapping("jump")
	public ResponseEntity<?> save(@RequestBody List<JumpIssue> issues) {
		try {
			HashMap response = new HashMap<>();
			response.put("message", "Ok.");
			this.jumpService.save(issues);

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.ok("Not ok.");
		}
		
	}

    @GetMapping("jump/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		try {
			JumpIssue issue = this.jumpService.findById(id);
			return ResponseEntity.ok(issue);
		} catch (Exception e) {
			logger.error("Error at JumpController, method findById(): " + id, e);
            return ResponseEntity.ok("Not ok.");
		}
		
	}

		 
}
