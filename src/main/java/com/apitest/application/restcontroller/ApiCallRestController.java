package com.apitest.application.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apitest.application.service.ApiCallService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@Tag(name = "External Api endpoints", description = "These endpoints manages testing with different sprigboot http async api calls")
@AllArgsConstructor
@Slf4j
public class ApiCallRestController {
	private final ApiCallService apiService;
	
	@GetMapping(value = {"/async-http-client"}, produces = {"application/json"})
	  @Operation(summary = "Fetch Team", description = "This service fetches team")
	  @ApiResponses({@ApiResponse(responseCode = "200", description = "Team Fetched successfully", content = {@Content(schema = @Schema(implementation = String.class))}), @ApiResponse(responseCode = "404", description = "Team Not Found With Resource ID"), @ApiResponse(responseCode = "401", description = "ACCESS DENIED! Unauthorized access", content = {@Content(schema = @Schema(implementation = String.class))}), @ApiResponse(responseCode = "500", description = "INTERNAL SERVER FAILURE! Api Failure")})
	  public ResponseEntity<?> getTeam() {
	    log.info("Api Call For Async-Http-Client-Call");
	    try {
	         Boolean result = apiService.callApiWithAsyncHttpClient();
	         if (result) {
	        	 return new ResponseEntity<>(result, HttpStatus.OK); 
	         }
	        return new ResponseEntity<>(result, HttpStatus.NOT_IMPLEMENTED);
	      
	    } catch (Exception e) {
	      log.error("Exception occurred " + e);
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    } 
	  }
	
	@GetMapping(value = {"/rest-template"}, produces = {"application/json"})
	  @Operation(summary = "Fetch Team", description = "This service fetches team")
	  @ApiResponses({@ApiResponse(responseCode = "200", description = "Team Fetched successfully", content = {@Content(schema = @Schema(implementation = String.class))}), @ApiResponse(responseCode = "404", description = "Team Not Found With Resource ID"), @ApiResponse(responseCode = "401", description = "ACCESS DENIED! Unauthorized access", content = {@Content(schema = @Schema(implementation = String.class))}), @ApiResponse(responseCode = "500", description = "INTERNAL SERVER FAILURE! Api Failure")})
	  public ResponseEntity<?> getTeam2() {
	    log.info("Api Call For Async-Http-Client-Call");
	    try {
	         Boolean result = apiService.callApiWithRestTemplate();
	         if (result) {
	        	 return new ResponseEntity<>(result, HttpStatus.OK); 
	         }
	        return new ResponseEntity<>(result, HttpStatus.NOT_IMPLEMENTED);
	      
	    } catch (Exception e) {
	      log.error("Exception occurred " + e);
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    } 
	  }
	
	@GetMapping(value = {"/webclient"}, produces = {"application/json"})
	  @Operation(summary = "Fetch Team", description = "This service fetches team")
	  @ApiResponses({@ApiResponse(responseCode = "200", description = "Team Fetched successfully", content = {@Content(schema = @Schema(implementation = String.class))}), @ApiResponse(responseCode = "404", description = "Team Not Found With Resource ID"), @ApiResponse(responseCode = "401", description = "ACCESS DENIED! Unauthorized access", content = {@Content(schema = @Schema(implementation = String.class))}), @ApiResponse(responseCode = "500", description = "INTERNAL SERVER FAILURE! Api Failure")})
	  public ResponseEntity<?> getTeam3() {
	    log.info("Api Call For Async-Http-Client-Call");
	    try {
	         Boolean result = apiService.callApiWithWebClient();
	         if (result) {
	        	 return new ResponseEntity<>(result, HttpStatus.OK); 
	         }
	        return new ResponseEntity<>(result, HttpStatus.NOT_IMPLEMENTED);
	      
	    } catch (Exception e) {
	      log.error("Exception occurred " + e);
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    } 
	  }
}
