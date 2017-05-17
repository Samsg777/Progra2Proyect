/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public interface UserOperations {

    User searchUser(String name);

    User searchUser(User user);
    
    User searchUser(String username, String password);

    ArrayList<User> sortUsers(User allUsers[]);

    ArrayList<User> sortUsers(String identification, User allUsers[]);

}
