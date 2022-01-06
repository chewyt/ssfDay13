package chewyt.project.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;



import org.springframework.stereotype.Service;

@Service
public class Contact {

    private String name;
    private String email;
    private int mobile;
    private String id;
    static public String path;

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String generateId() {
        List<Character> hexList = (Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', '1', '2', '3', '4', '5', '6', '7', '8',
                '9', '0'));
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(hexList.get(random.nextInt(hexList.size() - 1)));
        }
        this.id = sb.toString();

        return id;
    }

    public File createFile() throws IOException {

        Path p = Paths.get(path, id);
        File f  =p.toFile();
        if (!f.exists()) 
            f.createNewFile();
        
        System.out.println(this.id);
        System.out.println(this.email);
        System.out.println(this.name);
        System.out.println(this.mobile);
        System.out.println(path);

        return f;
    }

    public boolean writeData(File file) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(this.id+"\n");
            writer.append(this.name+"\n");
            writer.append(this.email+"\n");
            writer.append(this.mobile+"\n");
            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean loadfile(String id){

        Path p = Paths.get(path, id);
        File f  =p.toFile();
        try (FileReader reader = new FileReader(f)) {
            
            BufferedReader br = new BufferedReader(reader);
            this.id=br.readLine();
            this.name=br.readLine();
            this.email=br.readLine();
            this.mobile=Integer.parseInt(br.readLine());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
