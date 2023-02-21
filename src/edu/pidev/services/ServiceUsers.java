/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.services;

import edu.pidev.models.Users;
import edu.pidev.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mariem OUESLATI
 */
public class ServiceUsers implements Iservice<Users> {

    Connection cnx = DataSource.getInstance().getCnx();

//    @Override
//    public void ajouter(Users u) {
//        try {
//            String req = "INSERT INTO `users` (`titre` ,`nom`, `prenom`) VALUES ('" + u.getTitre() + "','" + u.getNom() + "', '" + u.getPrenom() + "')";
//            Statement st = cnx.createStatement();
//            st.executeUpdate(req);
//            System.out.println("User created !");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

    public void ajouter2(Users u) {
        try {
            String req = "INSERT INTO `users` (`id`,`nom`, `prenom`) VALUES (?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
              ps.setInt(1, u.getId());
             ps.setString(2, u.getNom());
            ps.setString(3, u.getPrenom());
           
            //ps.setString(1, u.getTitre());
            ps.executeUpdate();
            System.out.println("User added successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `users` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("user deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Users u) {
        try {
            String req = "UPDATE `users` SET  `nom` = '" + u.getNom() + "', `prenom` = '" + u.getPrenom() + "' WHERE `id` = " + u.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("User updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Users> getAll() {
        List<Users> list = new ArrayList<>();
        try {
            String req = "Select * from users";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Users u = new Users(rs.getInt("id"), rs.getString("titre"), rs.getString("nom"), rs.getString("prenom"), rs.getDate("date_naissance"));
                list.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Users getOneById(int id) {
        Users u = null;
        try {
            String req = "Select * from users";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                u = new Users(rs.getInt(1), rs.getString("nom"), rs.getString("prenom"));
                System.out.println(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return u;
       
    }

    @Override
    public void ajouter(Users p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
