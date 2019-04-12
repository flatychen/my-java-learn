package cn.flaty.search;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class BinarySearchTest {

	protected Integer array[];

	@Before
	public void init() {
		array = new Integer[6];
		Random random = new Random(new Date().getTime());
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
	}

	@Test
	public void test() {
		Arrays.sort(array);
		System.out.println(Arrays.toString(array)); 
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.search(array, 6));;
	}
	
	
	@Test
	public void testRecrusive() {
		Arrays.sort(array);
		System.out.println(Arrays.toString(array)); 
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.searchRecursive(array, 6));;
	}

}
