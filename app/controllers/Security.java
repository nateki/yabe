/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

/**
 *
 * @author Kavinaesh
 */
import models.*;
public class Security extends Secure.Security{
/*
    static boolean authenticate(String username, String password) {
        return true;
    }
*/
static boolean authenticate(String username, String password) {
    return User.connect(username, password) != null;
}
static void onDisconnected() {
    Application.index();
}
static void onAuthenticated() {
    Admin.index();
}
static boolean check(String profile) {
    if("admin".equals(profile)) {
        return User.find("byEmail", connected()).<User>first().isAdmin;
    }
    return false;
}
}
