package stackbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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
		
		ArrayList<Box> boxStack = new ArrayList<Box>();
		
		for(int i = 1; i < 10; ++i) {
			boxStack.add(new Box(i, i, i));
		}
		
		Collections.sort(boxStack, new Comparator<Box>(){

			@Override
			public int compare(Box o1, Box o2) {
				return o2.height_ - o1.height_;
			}
			
		});

		List<Box> resultBoxList = getMaxHeightBoxNaiveList(boxStack);
		
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

	public static List<Box> getMaxHeightBoxNaiveList(ArrayList<Box> boxStack) {

		Collections.sort(boxStack, new Comparator<Box>(){
			@Override
			public int compare(Box o1, Box o2) {
				return o2.height_ - o1.height_;
			}
		});

		return getMaxHeightBoxNaiveList(boxStack, new ArrayList<Box>(), 0);
	}
	
	public static ArrayList<Box> getMaxHeightBoxListOrdered(ArrayList<Box> boxStack) {

		Collections.sort(boxStack, new Comparator<Box>(){
			@Override
			public int compare(Box o1, Box o2) {
				return o2.height_ - o1.height_;
			}
			
		});
		
		if(boxStack.isEmpty()) {
			return new ArrayList<Box>();
		}

		return getMaxHeightBoxListOrdered(boxStack, null, 0);
	}
	
	public static ArrayList<Box> getMaxHeightBoxListCached(ArrayList<Box> boxStack) {

		Collections.sort(boxStack, new Comparator<Box>(){
			@Override
			public int compare(Box o1, Box o2) {
				return o2.height_ - o1.height_;
			}
			
		});
		
		if(boxStack.isEmpty()) {
			return new ArrayList<Box>();
		}
		HashMap<Box, ArrayList<Box>> map = new HashMap<Box, ArrayList<Box>>();

		return getMaxHeightBoxListCached(boxStack, null, map);
	}
	
	public static ArrayList<Box> getMaxHeightBoxListRecursive(ArrayList<Box> boxStack) {
		
		if(boxStack.isEmpty()) {
			return new ArrayList<Box>();
		}

		return getMaxHeightBoxListRecursive(boxStack, null);
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Box> getMaxHeightBoxNaiveList(ArrayList<Box> boxList, ArrayList<Box> subList, int index) {
		if(boxList.isEmpty()) {
			return new ArrayList<Box>();
		}
		
		if(index >= boxList.size()) {
			return subList;
		}
		
		// 안 넣은거
		ArrayList<Box> nonAddResult = getMaxHeightBoxNaiveList(boxList, (ArrayList<Box>) subList.clone(), index+1);
		int maxHeightNon = getMaxHeight(nonAddResult);
		
		// 넣은거(넣을 수 있으면)
		ArrayList<Box> addResult = new ArrayList<Box>();
		int maxHeightAdd = 0;
		if(canStack(boxList, index-1, index)) {
			subList.add(boxList.get(index));
			addResult = getMaxHeightBoxNaiveList(boxList, (ArrayList<Box>) subList.clone(), index+1);
			maxHeightAdd = getMaxHeight(addResult);
		}
		if(maxHeightNon < maxHeightAdd) {
			return addResult;
		} else {
			return nonAddResult;
		}
	}
	
	public static ArrayList<Box> getMaxHeightBoxListOrdered(ArrayList<Box> boxList, Box bottom, int idx) {
		ArrayList<Box> maxStack = null;
		int maxHeight = 0;
		//for(Box box : boxList) {
		for(int i = idx; i < boxList.size(); ++i) {
			if(boxList.get(i).canStack(bottom)) {
				ArrayList<Box> tmpList = getMaxHeightBoxListOrdered(boxList, boxList.get(i), idx + 1);
				int height = getMaxHeight(tmpList);
				if(maxHeight < height) {
					maxHeight = height;
					maxStack = tmpList;
				}
			}
		}
		if(maxStack == null) {
			maxStack = new ArrayList<Box>();
		}
		if(bottom != null) {
			maxStack.add(0, bottom);
		}

		return maxStack;
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Box> getMaxHeightBoxListCached(ArrayList<Box> boxList, Box bottom, HashMap<Box, ArrayList<Box>> cacheMap) {
		ArrayList<Box> maxStack = null;
		int maxHeight = 0;
		for(Box box : boxList) {
			if(box.canStack(bottom)) {
				ArrayList<Box> tmpList = null;
				if(cacheMap.containsKey(bottom)) {
					tmpList = cacheMap.get(bottom);
				} else {
					tmpList = getMaxHeightBoxListCached(boxList, box, cacheMap);
				}
				int height = getMaxHeight(tmpList);
				if(maxHeight < height) {
					maxHeight = height;
					maxStack = tmpList;
				}
			}
		}
		if(maxStack == null) {
			maxStack = new ArrayList<Box>();
		}
		if(bottom != null) {
			maxStack.add(0, bottom);
		}
		cacheMap.put(bottom, maxStack);

		return (ArrayList<Box>)maxStack.clone();
	}
	
	public static ArrayList<Box> getMaxHeightBoxListRecursive(ArrayList<Box> boxList, Box bottom) {
		ArrayList<Box> maxStack = null;
		int maxHeight = 0;
		for(Box box : boxList) {
			if(box.canStack(bottom)) {
				ArrayList<Box> tmpList = getMaxHeightBoxListRecursive(boxList, box);
				int height = getMaxHeight(tmpList);
				if(maxHeight < height) {
					maxHeight = height;
					maxStack = tmpList;
				}
			}
		}
		if(maxStack == null) {
			maxStack = new ArrayList<Box>();
		}
		if(bottom != null) {
			maxStack.add(0, bottom);
		}

		return maxStack;
	}
	
	private static boolean canStack(ArrayList<Box> boxList, int index, int index2) {

		if(index < 0) {
			return true;
		}
		
		if(index2 >= boxList.size()) {
			return false;
		} else {
			return canStack(boxList.get(index), boxList.get(index2));
		}
	}

	private static boolean canStack(Box box, Box box2) {
		return box.isGreaterThan(box2);
	}


}
