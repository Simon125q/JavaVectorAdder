import java.util.ArrayList;
import java.util.Iterator;

class Vector {
    ArrayList<Integer> elements = new ArrayList<>();
    int length;

    public static void main(String[] args) {
        Vector v1 = new Vector("12, 78$, 34, 56");
        System.out.println("v1 length is: " + v1.length);
        Vector v2 = new Vector("134, 904, 46, 9");
        System.out.println("v2 length is: " + v2.length);
        try {
            Vector v3 = new Vector(v1.addVectors(v2));
            System.out.println("v3 length is: " + v3.length);
        }
        catch(DifferentLengthVectorsException dle) {
            System.out.println(dle.getMessage());
        }
    }

    public Vector(String values) {
        ValuesExtracter myExtracter= new ValuesExtracter();
        elements = myExtracter.extractToArray(values);
        length = elements.size();
    }

    public Vector(Vector other){
        this.elements.clear();
        this.elements.addAll(other.elements);
        length = this.elements.size();
    }

    public Vector addVectors(Vector other) throws DifferentLengthVectorsException {
        Vector res = new Vector(this);

        res.elements.addAll(other.elements);

        return res;
    }

    @Override
    public String toString()
    {
        Iterator<Integer> myIterator = elements.iterator();
        String printResult = "";
        printResult += "[";
        while(myIterator.hasNext())
        {
            printResult += String.valueOf(myIterator.next());
            if(myIterator.hasNext())
            {
                printResult += ", ";
            }
        }

        printResult += "]";
        
        return printResult;
    }
}