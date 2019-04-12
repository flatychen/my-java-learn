package cn.flaty.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public  class SortTest {
	
	
	protected Integer array[];
	
	@Before
	public void init(){
		array = new Integer[10];
		Random random = new Random(new Date().getTime());
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100);
		}
	}
	
	
	
	@Test
	public void selectTest(){
		SelectionSort ss = new SelectionSort();
		ss.sort(array);
		System.out.println(Arrays.toString(array));
	}
	
	
	@Test
	public void insertTest(){
		InsertSort ss = new InsertSort();
		ss.sort(array);
		System.out.println(Arrays.toString(array));
	}
	
	@Test
	public void QuickTest(){
		QuickSort ss = new QuickSort();
		ss.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
