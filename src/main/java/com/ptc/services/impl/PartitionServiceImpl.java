package com.ptc.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ptc.services.PartitionService;

@Service
public class PartitionServiceImpl implements PartitionService {

	Logger logger = LoggerFactory.getLogger(PartitionServiceImpl.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<List<Integer>> partition(List<Integer> list, Integer taille) {
		/*
		 * Here we can throw exception or display a mesg or return an empty list
		 * It depends on the need
		 */
		if(list == null || taille == null || taille < 1){
			logger.error("The list and the taille fields must be filled!");
			return null;
		}

		List<List<Integer>> resultList = new ArrayList<>();
		for (int i = 0; i < list.size(); i += taille) {
			int end = i + taille;
			if (end < list.size()) {
				resultList.add(list.subList(i, end));
			} else if (i == list.size() - 1) {
				resultList.add(Arrays.asList(list.get(list.size() - 1)));

			} else {
				resultList.add(list.subList(i, list.size()));
			}
		}

		return resultList;
	}

}
