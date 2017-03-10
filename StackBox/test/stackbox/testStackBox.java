package stackbox;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class testStackBox {

	@Test
	public void testGetMaxHeightBoxList() {

		ArrayList<Box> boxStack = new ArrayList<Box>();
		
		boxStack.add(new Box(9, 9, 1));
		boxStack.add(new Box(8, 8, 4));
		boxStack.add(new Box(6, 6, 3));
		boxStack.add(new Box(5, 5, 2));
		boxStack.add(new Box(3, 3, 3));
		boxStack.add(new Box(2, 2, 1));
		
		List<Box> maxHeightBoxNaiveList = StackBox.getMaxHeightBoxNaiveList(boxStack);
		System.out.println(maxHeightBoxNaiveList);
		assertEquals(22, StackBox.getMaxHeight(maxHeightBoxNaiveList));
		
		List<Box> maxHeightBoxNewList = StackBox.getMaxHeightBoxListOrdered(boxStack);
		System.out.println(maxHeightBoxNewList);
		assertEquals(22, StackBox.getMaxHeight(maxHeightBoxNewList));
	}
	
	@Test
	public void testGetMaxHeightBoxList2() {

		ArrayList<Box> boxStack = new ArrayList<Box>();
		
		boxStack.add(new Box(9, 9, 1));
		boxStack.add(new Box(8, 8, 4));
		boxStack.add(new Box(6, 6, 3));
		boxStack.add(new Box(5, 5, 2));
		boxStack.add(new Box(3, 3, 3));
		boxStack.add(new Box(2, 2, 1));
		boxStack.add(new Box(1, 1, 0));
		
		List<Box> maxHeightBoxNaiveList = StackBox.getMaxHeightBoxNaiveList(boxStack);
		System.out.println(maxHeightBoxNaiveList);
		assertEquals(23, StackBox.getMaxHeight(maxHeightBoxNaiveList));
		
		List<Box> maxHeightBoxNewList = StackBox.getMaxHeightBoxListOrdered(boxStack);
		System.out.println(maxHeightBoxNewList);
		assertEquals(22, StackBox.getMaxHeight(maxHeightBoxNewList));
	}
	
	@Test
	public void testGetMaxHeightBoxList3() {

		ArrayList<Box> boxStack = new ArrayList<Box>();
		
		boxStack.add(new Box(9, 9, 10));
		boxStack.add(new Box(8, 8, 9));
		boxStack.add(new Box(6, 1, 3));
		boxStack.add(new Box(5, 9, 2));
		boxStack.add(new Box(3, 3, 3));
		boxStack.add(new Box(2, 2, 1));
		boxStack.add(new Box(1, 1, 0));
		
		List<Box> maxHeightBoxNaiveList = StackBox.getMaxHeightBoxNaiveList(boxStack);
		System.out.println(maxHeightBoxNaiveList);
		assertEquals(26, StackBox.getMaxHeight(maxHeightBoxNaiveList));
		
		List<Box> maxHeightBoxNewList = StackBox.getMaxHeightBoxListOrdered(boxStack);
		System.out.println(maxHeightBoxNewList);
		assertEquals(26, StackBox.getMaxHeight(maxHeightBoxNewList));
	}
	
	@Test
	public void testAllListAlgorithm() {

		ArrayList<Box> boxStack = new ArrayList<Box>();
		
		boxStack.add(new Box(9, 9, 10));
		boxStack.add(new Box(8, 8, 9));
		boxStack.add(new Box(6, 1, 3));
		boxStack.add(new Box(5, 9, 2));
		boxStack.add(new Box(3, 3, 3));
		boxStack.add(new Box(2, 2, 1));
		boxStack.add(new Box(1, 1, 0));
		
		List<Box> maxHeightRecursiveList = StackBox.getMaxHeightBoxListRecursive(boxStack);
		int heightRecursive = StackBox.getMaxHeight(maxHeightRecursiveList);

		List<Box> maxHeightOrderedList = StackBox.getMaxHeightBoxListOrdered(boxStack);
		int heightOrdered = StackBox.getMaxHeight(maxHeightOrderedList);
		
		assertEquals(heightRecursive, heightOrdered);
		
		List<Box> maxHeightCachedList = StackBox.getMaxHeightBoxListCached(boxStack);
		int heightCached = StackBox.getMaxHeight(maxHeightCachedList);
		
		assertEquals(heightRecursive, heightCached);
	}
	
	@Test
	public void testGetMaxHeightBoxNaiveListPerformance() {

		ArrayList<Box> boxStack = new ArrayList<Box>();
		Random random = new Random();
		for(int i = 0; i < 90; ++i) {
			boxStack.add(new Box(random.nextInt(1000), random.nextInt(1000), random.nextInt(1000)));
		}
		
		List<Box> maxHeightBoxList = StackBox.getMaxHeightBoxNaiveList(boxStack);
		System.out.println(maxHeightBoxList);
	}

	@Test
	public void testGetMaxHeightBoxListRecursivePerformance() {

		ArrayList<Box> boxStack = new ArrayList<Box>();
		Random random = new Random();
		for(int i = 0; i < 300; ++i) {
			boxStack.add(new Box(random.nextInt(1000), random.nextInt(1000), random.nextInt(1000)));
		}
		
		List<Box> maxHeightBoxList = StackBox.getMaxHeightBoxListRecursive(boxStack);
		System.out.println(maxHeightBoxList);
	}
	
	@Test
	public void testGetMaxHeightBoxListOrderedPerformance() {

		ArrayList<Box> boxStack = new ArrayList<Box>();
		Random random = new Random();
		for(int i = 0; i < 300; ++i) {
			boxStack.add(new Box(random.nextInt(1000), random.nextInt(1000), random.nextInt(1000)));
		}
		
		List<Box> maxHeightBoxList = StackBox.getMaxHeightBoxListOrdered(boxStack);
		System.out.println(maxHeightBoxList);
	}

	@Test
	public void testGetMaxHeightBoxListCachedPerformance() {

		ArrayList<Box> boxStack = new ArrayList<Box>();
		Random random = new Random();
		for(int i = 0; i < 1000; ++i) {
			boxStack.add(new Box(random.nextInt(1000), random.nextInt(1000), random.nextInt(1000)));
		}
		
		List<Box> maxHeightBoxList = StackBox.getMaxHeightBoxListCached(boxStack);
		System.out.println(maxHeightBoxList);
	}
	
}
