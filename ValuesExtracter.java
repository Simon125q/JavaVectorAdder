import java.util.ArrayList;


public class ValuesExtracter {
    public ArrayList<Integer> extractToArray(String stringValues)
    {
        ArrayList<Integer> result = new ArrayList<>();
      
        String[] toParse = stringValues.split(",");
        for(int index = 0; index < toParse.length; index++){
            if (isNumeric(toParse[index].strip()))
            {
                result.add(Integer.parseInt(toParse[index].strip()));
            }

        }

        return result;
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
