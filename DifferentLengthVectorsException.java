import java.util.ArrayList;

public class DifferentLengthVectorsException extends Exception {

    private ArrayList<Integer> lengths;

    public DifferentLengthVectorsException() {}

    public DifferentLengthVectorsException(String errorMessage) {
        super(errorMessage);
    }

    public DifferentLengthVectorsException(String errorMessage, ArrayList<Integer> lengths) {
        super(errorMessage);
        this.lengths = lengths;
    }

    public ArrayList<Integer> getVectorsLengths()
    {
        
        return lengths;
    }

}
