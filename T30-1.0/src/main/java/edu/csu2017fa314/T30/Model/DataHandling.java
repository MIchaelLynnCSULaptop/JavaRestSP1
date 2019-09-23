package edu.csu2017fa314.T30.Model;

import java.util.Arrays;
import java.util.HashMap;

public class DataHandling {

    public String[][] data;
    Model myModel;
    public DataHandling ()
    {
        data = new String[3][];
        myModel = new Model();
        myModel.readData();
        data = myModel.buildItinerary();
    }

    public String[][] getAllData() {
        return data;
    }

    public String[] searchData(String searchVal) {
        String[] result = new String[3];

        // get single object entry
        for (int i = 0; i < data.length; i++) {
            if (data[i][0].equals(searchVal)) {
                result = Arrays.copyOf(data[i], 3);
            }
        }
     return result;
    }




}
