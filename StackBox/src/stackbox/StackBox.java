package stackbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StackBox {
	
	static final int SIZE = 10;
	
	
	static void sortArrayDesc(Integer[] array) {
		Arrays.sort(array, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
				// return o2 - o1;
			}
		});
	}
	
	public static void main(String[] args) {
		
		List<Box> boxStack = new ArrayList<Box>();
		
		for(int i = 1; i < 10; ++i) {
			boxStack.add(new Box(i, i, i));
		}
		
		Collections.sort(boxStack, new Comparator<Box>(){

			@Override
			public int compare(Box o1, Box o2) {
				return o2.height_ - o1.height_;
			}
			
		});

		List<Box> resultBoxList = getMaxHeightBoxList(boxStack);
		
		System.out.println("Max height: " + getMaxHeight(resultBoxList));
		System.out.println("Max height box List: " + resultBoxList.toString());
		
	}

	public static int getMaxHeight(List<Box> resultBoxList) {
		if(resultBoxList == null) {
			return 0;
		}
		int result = 0;
		for(Box box: resultBoxList) {
			result += box.height_;
		}
		return result;
	}

	public static List<Box> getMaxHeightBoxList(List<Box> boxStack) {
		
		return new ArrayList<Box>();
	}

}
