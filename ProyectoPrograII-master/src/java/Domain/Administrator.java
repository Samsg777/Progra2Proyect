/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Domain;

/**
 *
 * @author Samuel
 */
public class Administrator extends User implements Employee{
    
    public Administrator(String identification, String name, String username, String password) {
        super(identification, name, username, password,"administrator");
    }
    
    public Administrator() {
        super();
    }
    
    
    
    @Override
    public float calculateSalary(float dailySalary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public boolean verifyUserLogin(String[] loginDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
