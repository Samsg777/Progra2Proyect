package Data;

import Domain.Operator;
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
public class OperatorData {
    private final String jsonFilePath;
    public OperatorData() {
        this.jsonFilePath = "C:\\Users\\Samuel\\Documents\\NetBeansProjectsp\\ProyectoProgra2.0.1\\files\\User.json";
    }
    public void insertOperator(Operator operator) throws IOException, org.json.simple.parser.ParseException {
        JSONObject customerObject = new JSONObject();
        customerObject.put("identification", operator.getIdentification());
        customerObject.put("name", operator.getName());
        customerObject.put("username", operator.getUsername());
        customerObject.put("password", operator.getPassword());
        customerObject.put("phone", operator.getPhone());
        customerObject.put("email", operator.getEmail());
        customerObject.put("role", operator.getRole());
        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(jsonFilePath, true)) {
            file.write(customerObject.toJSONString() + "\r\n");
        }
    }
    public LinkedList<Operator> getAllOperators() throws ParseException, org.json.simple.parser.ParseException {
        LinkedList<Operator> operators = new LinkedList<>();
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
                Operator operator = new Operator();

                operator.setIdentification(jsonObject.get("identification").toString());
                operator.setName(jsonObject.get("name").toString());
                operator.setUsername(jsonObject.get("username").toString());
                operator.setPassword(jsonObject.get("password").toString());
                operator.setEmail(jsonObject.get("email").toString());
                operator.setPhone(jsonObject.get("phone").toString());
                operator.setRole(jsonObject.get("role").toString());
                System.out.println(operator.toString());
                operators.add(operator);
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
        return operators;
    }
    
    public void deleteAdministrator(String username) throws ParseException, org.json.simple.parser.ParseException {        
        try {            
            JSONObject administratorObject;
            File file = new File(jsonFilePath);            
            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("operatorTemp.json");            
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
    
    public void modifyAdminFromFile(String username, Operator operator) throws ParseException, org.json.simple.parser.ParseException {        
        try {            
            JSONObject operatorObject;            
            File file = new File(jsonFilePath);            
            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("operatorTemp.json");            
            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));            
            String line = null;            
            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {                
                operatorObject = (JSONObject) new JSONParser().parse(line);                
                if (!operatorObject.get("username").toString().equals(username)) {
                    printWriter.println(line);
                    printWriter.flush();
                } else {                    
                    operatorObject.put("identification", operator.getIdentification());
                    operatorObject.put("name", operator.getName());
                    operatorObject.put("username", operator.getUsername());
                    operatorObject.put("password", operator.getPassword());
                    operatorObject.put("role", operator.getRole()); 
                    operatorObject.put("email", operator.getEmail()); 
                    operatorObject.put("phone", operator.getPhone());
                    printWriter.println(operatorObject.toJSONString());
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
    
    public Operator getAdministratorByUsername(String username) throws ParseException, org.json.simple.parser.ParseException {
        Operator operator = new Operator();
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
                    operator.setIdentification(jsonObject.get("identification").toString());
                    operator.setName(jsonObject.get("name").toString());
                    operator.setUsername(jsonObject.get("username").toString());
                    operator.setPassword(jsonObject.get("password").toString());
                    operator.setRole(jsonObject.get("role").toString());
                    operator.setEmail(jsonObject.get("email").toString());
                    operator.setPhone(jsonObject.get("phone").toString());
                    System.out.println(operator.toString());
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
        return operator;
    }
}