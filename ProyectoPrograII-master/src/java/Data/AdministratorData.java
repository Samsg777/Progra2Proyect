package Data;

import Domain.Administrator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * @author Samuel
 */
public class AdministratorData extends CustomerData{
    
    private final String jsonFilePath;

    public AdministratorData() {
        this.jsonFilePath = "C:\\Users\\Samuel\\Documents\\NetBeansProjectsp\\ProyectoProgra2.0.1\\files\\User.json";
    }

    public void insertAdministrator(Administrator administrator) throws IOException, org.json.simple.parser.ParseException {
        JSONObject customerObject = new JSONObject();
        customerObject.put("identification", administrator.getIdentification());
        customerObject.put("name", administrator.getName());
        customerObject.put("username", administrator.getUsername());
        customerObject.put("password", administrator.getPassword());
        customerObject.put("role", administrator.getRole());
        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(jsonFilePath, true)) {
            file.write(customerObject.toJSONString() + "\r\n");
        }
    }

    public LinkedList<Administrator> getAllAdministrators() throws ParseException, org.json.simple.parser.ParseException {
        LinkedList<Administrator> administrators = new LinkedList<>();
        ArrayList<JSONObject> jsonArray = new ArrayList<>();
        JSONObject jsonObject;
        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(jsonFilePath);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                jsonObject = (JSONObject) new JSONParser().parse(line);
                jsonArray.add(jsonObject);
                Administrator administrator = new Administrator();

                administrator.setIdentification(jsonObject.get("identification").toString());
                administrator.setName(jsonObject.get("name").toString());
                administrator.setUsername(jsonObject.get("username").toString());
                administrator.setPassword(jsonObject.get("password").toString());
                administrator.setRole(jsonObject.get("role").toString());
                System.out.println(administrator.toString());
                administrators.add(administrator);
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + jsonFilePath + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + jsonFilePath + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return administrators;
    }
    
    public void deleteAdministrator(String username) throws ParseException, org.json.simple.parser.ParseException {        
        try {            
            JSONObject administratorObject;
            File file = new File(jsonFilePath);            
            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("adminTemp.json");            
            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
                String line = null;                
                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = bufferedReader.readLine()) != null) {
                    administratorObject = (JSONObject) new JSONParser().parse(line);                    
                    if (!administratorObject.get("username").toString().equals(username)) {                        
                        printWriter.println(line);
                        printWriter.flush();
                    }
                }                
                bufferedReader.close();
            }            
            //Delete the original file
            if (!file.delete()) {                
                //no se pudo eliminar el archivo
            }            
            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(file)) {                
            }            
        } catch (FileNotFoundException ex) {            
        } catch (IOException ex) {            
        }
    }
    
    public void modifyAdminFromFile(String username, Administrator administrator) throws ParseException, org.json.simple.parser.ParseException {        
        try {            
            JSONObject administratorObject;            
            File file = new File(jsonFilePath);            
            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("adminTemp.json");            
            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));            
            String line = null;            
            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {                
                administratorObject = (JSONObject) new JSONParser().parse(line);                
                if (!administratorObject.get("username").toString().equals(username)) {
                    printWriter.println(line);
                    printWriter.flush();
                } else {                    
                    administratorObject.put("identification", administrator.getIdentification());
                    administratorObject.put("name", administrator.getName());
                    administratorObject.put("username", administrator.getUsername());
                    administratorObject.put("password", administrator.getPassword());
                    administratorObject.put("role", administrator.getRole());                                      
                    printWriter.println(administratorObject.toJSONString());
                }
            }            
            bufferedReader.close();
            printWriter.close();            
            //Delete the original file
            if (!file.delete()) {
                //no se pudo eliminar el archivo
            }            
            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(file)) {                
                //no se pudo renombrar el archivo
            }            
        } catch (FileNotFoundException ex) {            
        } catch (IOException ex) {            
        }
    }
    
    
    public Administrator getAdministratorByUsername(String username) throws ParseException, org.json.simple.parser.ParseException {
        Administrator administrator = new Administrator();
        JSONObject jsonObject;        
        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(jsonFilePath);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {                
                jsonObject = (JSONObject) new JSONParser().parse(line);                
                if (jsonObject.get("username").toString().equals(username)) {                    
                    administrator.setIdentification(jsonObject.get("identification").toString());
                    administrator.setName(jsonObject.get("name").toString());
                    administrator.setUsername(jsonObject.get("username").toString());
                    administrator.setPassword(jsonObject.get("password").toString());
                    administrator.setRole(jsonObject.get("role").toString());
                    System.out.println(administrator.toString());
                }
                
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + jsonFilePath + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + jsonFilePath + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return administrator;
    }
}