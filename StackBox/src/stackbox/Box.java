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

	public boolean isGreaterThan(Box box2) {
		return (height_ > box2.height_) &&  (depth_ > box2.depth_) && (width_ > box2.width_) ;
	}
}
