package com.ptc.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.ptc.services.impl.PartitionServiceImpl;


@RunWith(SpringRunner.class)
public class PartitionServiceTest {

	@InjectMocks
	PartitionServiceImpl partitionServiceImpl;


	@Test
	public void partition_list_null() {
		//Given
		//When
		List<List<Integer>> resList = partitionServiceImpl.partition(null, 2);
		//Then
		assertThat(resList).isNull();
	}

	@Test
	public void partition_taille_null() {
		//Given
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		//When
		List<List<Integer>> resList = partitionServiceImpl.partition(list, null);
		//Then
		assertThat(resList).isNull();
	}

	@Test
	public void partition_taille_negative() {
		//Given
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		//When
		List<List<Integer>> resList = partitionServiceImpl.partition(list, -5);
		//Then
		assertThat(resList).isNull();
	}

	@Test
	public void partition_zero() {
		//Given
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Integer taille = 0;

		//When
		List<List<Integer>> resList = partitionServiceImpl.partition(list, taille);
		//Then
		assertThat(resList).isNull();
	}

	@Test
	public void partition_OK_Taille1() {
		//Given
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Integer taille = 1;
		//When
		List<List<Integer>> resList = partitionServiceImpl.partition(list, taille);
		//Then
		assertThat(resList).isNotNull();
		assertThat(resList).hasSize(5);
		assertThat(resList.get(0)).hasSize(1);
	}

	@Test
	public void partition_OK_taille2() {
		//Given
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Integer taille = 2;
		//When
		List<List<Integer>> resList = partitionServiceImpl.partition(list, taille);
		//Then
		assertThat(resList).isNotNull();
		assertThat(resList).hasSize(3);
		assertThat(resList.get(0)).hasSize(2);
		assertThat(resList.get(1)).hasSize(2);
		assertThat(resList.get(2)).hasSize(1);
	}

	@Test
	public void partition_OK_taille3() {
		//Given
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Integer taille = 3;
		//When
		List<List<Integer>> resList = partitionServiceImpl.partition(list, taille);
		//Then
		assertThat(resList).isNotNull();
		assertThat(resList).hasSize(2);
		assertThat(resList.get(0)).hasSize(3);
		assertThat(resList.get(1)).hasSize(2);
	}
}
