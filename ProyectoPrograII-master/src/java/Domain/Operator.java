package Domain;

/**
 *
 * @author Samuel
 */
public class Operator extends User implements Employee{

    private String phone;
    private String email;

    public Operator() {
        super();
    }

    
    
    public Operator(String phone, String email, String identification, String name, String username, String password) {
        super(identification, name, username, password,"operator");
        this.phone = phone;
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
