package Utilities;

import JSON.CovidJSONResponse;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

public class CovidJSONReader {

    public static CovidJSONResponse getCovidJSON()
    {
        CovidJSONResponse covidResponse = null;
        try(
                FileReader fileReader = new FileReader("./src/JSON/covid.json");
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            Gson gson = new Gson();
            covidResponse = gson.fromJson(jsonReader, CovidJSONResponse.class);
            System.out.println();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return covidResponse;
    }
}
