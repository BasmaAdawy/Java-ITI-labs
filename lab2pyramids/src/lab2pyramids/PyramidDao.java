package lab2pyramids;

import java.util.List;

public interface PyramidDao {

	public List<Pyramid> readPyramidsFromCSV(String filename);
	public Pyramid createPyramid(String [] metadata);
}
