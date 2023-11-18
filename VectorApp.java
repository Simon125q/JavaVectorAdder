import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class VectorApp {
    int vectorsNum;
    ArrayList<Vector> vectors = new ArrayList<>();

    public static void main(String[] args)
    {
        VectorApp myVectorApp = new VectorApp();
        myVectorApp.run(4);
        System.out.println("Success");
    }

    public void run(int vectorsNum) 
    {
        Scanner myScanner = new Scanner(System.in);
        
        try{
            this.vectorsNum = vectorsNum;
            FileHandler myFileHandler = new FileHandler();
            readVectors(myScanner);
            Vector resultVector = new Vector(addVectors());
            myFileHandler.saveData("addedVectors.txt", resultVector.elements);
        }
        catch(DifferentLengthVectorsException dlve){
            System.out.println(dlve);
            System.out.println("Vectors: " + dlve.getVectors() + " have according lengths: " + dlve.getVectorsLengths());
            readVectors(myScanner);
        }
        catch(IOException ioe){
            System.out.println(ioe);
            System.exit(0);
        }

        myScanner.close();
    }

    public void readVectors(Scanner myScanner)
    {
        vectors.clear();
        for(int vecIndex = 1; vecIndex <= vectorsNum; vecIndex++){
            System.out.println("Enter vector nr " + vecIndex + ":");
            Vector newVector = new Vector(myScanner.nextLine());
            vectors.add(newVector);
        }
    }

    public Vector addVectors() throws DifferentLengthVectorsException
    {
        checkDifferentVectorsLength();
        Iterator<Vector> vectorIterator = vectors.iterator();
        Vector resultVector = new Vector(vectorIterator.next());
        while (vectorIterator.hasNext())
        {
            resultVector = resultVector.addVectors(new Vector(vectorIterator.next()));
        }
        return resultVector;
    }

    private void checkDifferentVectorsLength() throws DifferentLengthVectorsException
    {
        Iterator<Vector> vectorIterator = vectors.iterator();
        int vec_size = vectorIterator.next().length;
        while (vectorIterator.hasNext())
        {
            int nextSize = vectorIterator.next().length;
            if (vec_size != nextSize)
            {
                System.out.println(vec_size + " != " + nextSize);
                throw new DifferentLengthVectorsException("Vectors have different lengths, you will need to reenter them.", vectors);
            }
        }
    }

}
