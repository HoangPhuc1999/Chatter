/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import model.User;

/**
 *
 * @author khuat
 */
public interface AuthorizationManager {
    
         public boolean isUserAuthorized(User user,String uri);

}
