package Domain;

/**
 * @author Samuel
 */
public class Role {
    private String roleName;
    private String accessibility;

    public Role(String roleName, String accessibility) {
        this.roleName = roleName;
        this.accessibility = accessibility;
    }

    public Role() {
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }   
}