/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Song Du
 */

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileFunction {
    public static void main(String args[]) throws IOException {
        String currentDirectory = System.getProperty("user.dir");
        String file = currentDirectory + "/User.txt";

        List<User> users = new ArrayList<>();
        ReadFile(file, users);
        
    }
    public static void CheckFile(String dir) throws IOException {
        File f = new File(dir);
        if(!f.exists()) {
           f.createNewFile();
        }
    }
    
    public static void WriteFile(String file, User users) {
        try {
            FileWriter fw = new FileWriter(file, true);
            
            User user = new User(users.getUserName(), users.getPassword());
            
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(user.toString());
            
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("Lỗi ghi file: " + ex);
        }
    }
    
    public static void ReadFile(String file, List<User> users) {
        try {
            FileReader fr = new FileReader(file);
            //Bước 2: Đọc dữ liệu
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null){
              String[] user = line.split("-");
              User tmp = new User (user[0], user[1]);
              users.add(tmp);
              System.out.println(tmp.getPassword());
            }
            fr.close();
            br.close();
        } catch (IOException ex) {
             System.out.println("Lỗi đọc file: "+ex);
        }
    }
}
