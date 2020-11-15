package com.ptc.services;

import java.util.List;

public interface PartitionService {

	/**
	 * Partition the given list according the the given taille 
	 * @param list
	 * @param taille
	 * @return List<List<Integer>>
	 */
	public List<List<Integer>> partition(List<Integer> list, Integer taille);
}
