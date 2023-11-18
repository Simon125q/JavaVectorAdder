import java.util.ArrayList;
import java.util.Iterator;

public class DifferentLengthVectorsException extends Exception {

    private ArrayList<Vector> vectors;

    public DifferentLengthVectorsException() {}

    public DifferentLengthVectorsException(String errorMessage) {
        super(errorMessage);
    }

    public DifferentLengthVectorsException(String errorMessage, ArrayList<Vector> vectors) {
        super(errorMessage);
        this.vectors = vectors;
    }

    public ArrayList<Integer> getVectorsLengths()
    {
        ArrayList<Integer> lengths = new ArrayList<>();
        Iterator<Vector> vectorIterator = vectors.iterator();
        while (vectorIterator.hasNext())
        {
            lengths.add(vectorIterator.next().length);
        }
        return lengths;
    }

    public ArrayList<Vector> getVectors()
    {
        return vectors;
    }
}
