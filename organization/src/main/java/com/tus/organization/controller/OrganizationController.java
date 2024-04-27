package com.tus.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tus.organization.dto.OrgContactInfoDto;
import com.tus.organization.entity.Organization;
import com.tus.organization.repository.OrganizationRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class OrganizationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private Environment environment;
    
    @Autowired
    private OrgContactInfoDto orgContactInfoDto;	
	
	@Autowired
	OrganizationRepository repository;
	
	@PostMapping("/add-org")
	public Organization add(@RequestBody Organization organization) {
		LOGGER.info("Organisation add: {}", organization);
		return repository.add(organization);
	}
	
	@GetMapping("/{id}")
	public Organization findById(@PathVariable("id") Long id) {
		LOGGER.info("Organisation find: id={}", id);
		return repository.findById(id);
	}
	 
	 @GetMapping("/contact-info")
	    public ResponseEntity<OrgContactInfoDto> getContactInfo() {
	        return ResponseEntity
	                .status(HttpStatus.OK)
	                .body(orgContactInfoDto);
	    }
	 
	 @GetMapping("/java-version")
	    public ResponseEntity<String> getJavaVersion() {
	        return ResponseEntity
	                .status(HttpStatus.OK)
	                .body(environment.getProperty("JAVA_HOME"));
	    }

}
