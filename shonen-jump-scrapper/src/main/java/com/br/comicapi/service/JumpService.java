package com.br.comicapi.service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.br.comicapi.model.JumpIssue;
import com.br.comicapi.repository.JumpIssueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.br.comicapi.utils.DBuilder;

@Component(value = "JumpService")
public class JumpService {

	@Autowired
	private JumpIssueRepository repository;

	
	public void save(List<JumpIssue> issues) throws Exception {
		this.repository.saveAll(issues);
	}

    public JumpIssue findById(Long id) throws Exception {
        JumpIssue issue = this.repository.findById(id).get();
        return issue;
    }
	
}
