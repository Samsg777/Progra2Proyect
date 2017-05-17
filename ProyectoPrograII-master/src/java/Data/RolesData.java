package Data;

import Domain.Role;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author Samuel
 */
public class RolesData {
        private final String jsonFilePath;
    public RolesData() {
        this.jsonFilePath = "C:\\Users\\Samuel\\Documents\\NetBeansProjectsp\\ProyectoProgra2.0.1\\files\\Roles.json";
    }
    
    public void insertRole(Role role) throws IOException, org.json.simple.parser.ParseException {
        JSONObject roleObject = new JSONObject();
        roleObject.put("accessibility", role.getAccessibility());
        roleObject.put("name", role.getRoleName());
        
        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(jsonFilePath, true)) {
            file.write(roleObject.toJSONString() + "\r\n");
        }
    }
    public LinkedList<Role> getAllRoles() throws ParseException, org.json.simple.parser.ParseException {
        LinkedList<Role> roles = new LinkedList<>();
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
                Role role = new Role();
                role.setAccessibility(jsonObject.get("accessibility").toString());
                role.setRoleName(jsonObject.get("name").toString());
                System.out.println(role.toString());
                roles.add(role);
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
        return roles;
    }
    
    public void deleteRole(String roleName) throws ParseException, org.json.simple.parser.ParseException {        
        try {            
            JSONObject roleObject;
            File file = new File(jsonFilePath);            
            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("roleTemp.json");            
            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
                String line = null;                
                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = bufferedReader.readLine()) != null) {
                    roleObject = (JSONObject) new JSONParser().parse(line);                    
                    if (!roleObject.get("name").toString().equals(roleName)) {                        
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
    
    public void modifyRoleFromName(String roleName, Role role) throws ParseException, org.json.simple.parser.ParseException {        
        try {            
            JSONObject roleObject;            
            File file = new File(jsonFilePath);            
            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("operatorTemp.json");            
            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));            
            String line = null;            
            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {                
                roleObject = (JSONObject) new JSONParser().parse(line);                
                if (!roleObject.get("name").toString().equals(roleName)) {
                    printWriter.println(line);
                    printWriter.flush();
                } else {                    
                    roleObject.put("accessibility", role.getAccessibility());
                    roleObject.put("name", role.getRoleName());
                    printWriter.println(roleObject.toJSONString());
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
}