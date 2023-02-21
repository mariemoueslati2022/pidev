/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.tests;

import edu.pidev.models.Users;
import edu.pidev.services.ServiceUsers;

/**
 *
 * @author Mariem OUESLATI
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
////          Users u1 = new Users("Abdelaziz", "M");
////          Users u2 = new Users("Tarak", "Ayari");
//  /       Users u3 = new Users("Samir", "Sankou7");
          Users u4 = new Users("ahlem3", "abidi3");
        
        ServiceUsers su = new ServiceUsers();
        
  //    su.ajouter2(u4);
//        su.ajouter(u2);
//        su.ajouter2(u3);
//        su.ajouter2(u4);*/
 su.modifier(u4);
//su.supprimer(4);
//        
      //  su.getOneById(1);
    }

    public MainClass() {
    }
    
}
