package stackbox;

public class Box {
	
	public Box(int height, int depth, int width) {
		height_ = height;
		depth_ = depth;
		width_ = width;
	}
	
	int height_;
	int depth_;
	int width_;
	
	@Override
	public String toString() {
		return String.format("(%d, %d, %d)", height_, depth_, width_);
		
	}
}
