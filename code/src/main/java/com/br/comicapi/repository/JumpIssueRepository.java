package com.br.comicapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.br.comicapi.model.JumpIssue;

@Component
public interface JumpIssueRepository extends CrudRepository<JumpIssue, Long> {

    Optional<JumpIssue> findById(Long id);

//    JumpIssue saveAll(List<JumpIssue> issues);
    
}
