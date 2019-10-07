package edu.jsu.mcis;

import java.io.*;
import java.util.*;
import com.opencsv.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Converter {
        
    @SuppressWarnings("unchecked")
    public static String csvToJson(String csvString) {
        
        String results = "";
        
        try {
            
            StringBuilder csvFile = new StringBuilder();
            try {
                BufferedReader reader = new BufferedReader(new FileReader("input.csv"));
                String line;
                while((line = reader.readLine()) != null) {
                    csvFile.append(line).append('\n');
                }
            }
            catch(IOException e) { e.printStackTrace(); }
            String csvStrings = csvFile.toString().trim();
            
            CSVReader reader = new CSVReader(new StringReader(csvString));
            List<String[]> full = reader.readAll();
            Iterator<String[]> iterator = full.iterator();
            
            JSONArray records = new JSONArray(); 
            JSONObject jsonObject = new JSONObject();
            String[] record;
            String jsonString = "";
                        
            while (iterator.hasNext()) {
                record = iterator.next();
                for (int i = 0; i < record.length; ++i) { 
                    jsonObject.put(record[i], record[i]); 
                }
                records.add(jsonObject); 
            }  
            jsonString = JSONValue.toJSONString(records);
        }
        catch(Exception e) { return e.toString(); }
        
        return results.trim();
        
    }
    
    public static String jsonToCsv(String jsonString) {
        
        String results = "";
        
        try {

            StringWriter writer = new StringWriter();
            CSVWriter csvWriter = new CSVWriter(writer, ',', '"', '\n');
            
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject)parser.parse(jsonString);
            
            
                        
        }
        
        catch(Exception e) { return e.toString(); }
        
        return results.trim();
        
    }

}