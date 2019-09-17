package edu.csu2017fa314.T30.View;

import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hello {
    Map<String, Object> model;

    public Hello ()
    {
        model = new HashMap<String, Object>();
    }

    public void setview(String data) {
        model.put("message", data);
    }

    public Map<String, Object> getview() {
        return model;
    }


}
