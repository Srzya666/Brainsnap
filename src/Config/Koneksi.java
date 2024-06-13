/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.DriverManager;

/**
 *
 * @author surya
 */
public class Koneksi {
    private static java.sql.Connection koneksi;
    
    public static java.sql.Connection getKoneksi(){
        if (koneksi==null){
            try{
                String url = "jdbc:mysql://localhost:3306/dbtebakgambar";
                String user = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(url,user,pass);
                System.out.println("koneksi sukses");
            }catch (Exception e){
                System.out.println("Error");
            }
        }
        return koneksi;
    }
    public static void main(String[] args) {
        getKoneksi();
    }
}
