package com.ptc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ptc.services.PartitionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
@Api(tags = "Partition")
@SwaggerDefinition(tags = {@Tag(name= "Partition", description = "Partition api")})
@RestController
public class PartitionController {

	@Autowired
	PartitionService partitionService;

	@ApiOperation(value= "Get partitioned list", response = List.class)
	@GetMapping(value = "api/partition")
	public List<List<Integer>> partition(@RequestParam List<Integer> list, @RequestParam Integer taille) {
		return partitionService.partition(list, taille);
	}

}
