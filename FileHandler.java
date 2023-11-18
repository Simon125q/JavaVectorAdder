import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FileHandler {

    public void saveData(String outFileName, ArrayList<Integer> result) throws IOException
    {
        
        FileWriter writer = new FileWriter(outFileName);
        Iterator<Integer> resultIterator = result.iterator();
        while (resultIterator.hasNext())
        {
            int val = resultIterator.next();
            writer.write(String.valueOf(val));
            if (resultIterator.hasNext())
            {
                writer.write(", ");
            }
        }
        writer.close();
    }
}
