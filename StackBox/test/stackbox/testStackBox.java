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
		
		List<Box> maxHeightBoxList = StackBox.getMaxHeightBoxNaiveList(boxStack);
		System.out.println(maxHeightBoxList);
		assertEquals(22, StackBox.getMaxHeight(maxHeightBoxList));
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
		
		List<Box> maxHeightBoxList = StackBox.getMaxHeightBoxNaiveList(boxStack);
		System.out.println(maxHeightBoxList);
		assertEquals(23, StackBox.getMaxHeight(maxHeightBoxList));
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
		
		List<Box> maxHeightBoxList = StackBox.getMaxHeightBoxNaiveList(boxStack);
		System.out.println(maxHeightBoxList);
		assertEquals(26, StackBox.getMaxHeight(maxHeightBoxList));
	}
	
	@Test
	public void testGetMaxHeightBoxListPerformance() {

		ArrayList<Box> boxStack = new ArrayList<Box>();
		Random random = new Random();
		for(int i = 0; i < 100; ++i) {
			boxStack.add(new Box(random.nextInt(10000), random.nextInt(10000), random.nextInt(10000)));
		}
		
		List<Box> maxHeightBoxList = StackBox.getMaxHeightBoxNaiveList(boxStack);
		System.out.println(maxHeightBoxList);
		assertEquals(26, StackBox.getMaxHeight(maxHeightBoxList));
	}
}
