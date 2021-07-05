package lab2pyramids;

import java.util.Comparator;

public class heightSort implements Comparator<Pyramid> {

	public int compare(Pyramid h1, Pyramid h2) {
		// TODO Auto-generated method stub
		return (int) (h1.getHeight() - h2.getHeight());
	}


}
