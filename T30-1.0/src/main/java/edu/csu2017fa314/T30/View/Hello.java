package edu.csu2017fa314.T30.View;

import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//testing CI
public class Hello {
    Map<String, Object> view;

    public Hello ()
    {
        view = new HashMap<String, Object>();
        view.put("Hello", this);
    }

    public void setview(String[][] data) {
        view.put("message", data);
    }

    public String test() {
        return "test";
    }

    public String test2() {
        return "test2";
    }
    public void setview(String[][] data, String[] target) {
        view.put("message", target);
    }

    public Map<String, Object> getview() {
        return view;
    }


}
