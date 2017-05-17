package Data;

import Domain.Fee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * @author Samuel
 */
public class FeeData {
    final String jsonFilePath;
    
    public FeeData() {
        this.jsonFilePath = "C:\\Users\\Samuel\\Documents\\NetBeansProjectsp\\ProyectoProgra2.0.1\\files\\Fee.json";
    }
    
    
    public void modifyFeeFromFile(long fee, String description) throws ParseException, org.json.simple.parser.ParseException, FileNotFoundException, IOException {
        try {
            JSONObject feeObject;
            Fee currentFee = new Fee();
            
            File file = new File(jsonFilePath);
            
            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("customersTemp.json");
            
            BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFilePath));
            PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));
            
            String line = null;
            
            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {
                feeObject = (JSONObject) new JSONParser().parse(line);
                if (!feeObject.get("description").toString().equals(description)) {
                    printWriter.println(line);
                    printWriter.flush();
                } else {                    
                    feeObject.put("description",currentFee.getDescription() );
                    feeObject.put("fee", currentFee.getFee());
                    
                    printWriter.println(feeObject.toJSONString());
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
    
    public long getFeeByVehicleType(String description,long newFee ) throws ParseException, org.json.simple.parser.ParseException {
        Fee fee = new Fee();
        JSONObject jsonObject;
        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(jsonFilePath);
            try ( // Always wrap FileReader in BufferedReader.
                    BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while ((line = bufferedReader.readLine()) != null) {
                    jsonObject = (JSONObject) new JSONParser().parse(line);
                    if (jsonObject.get("description").toString().equals(description)) {
                             fee.setFee(newFee);
                    }
                }
                // Always close files.
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + jsonFilePath + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + jsonFilePath + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return newFee;
    }
}