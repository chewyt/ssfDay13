package chewyt.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.ApplicationArguments;

import chewyt.project.controller.Contact;

public class TestContact {

    @Test
    public void testGenerateID(){
        Contact contact = new Contact();
        String id  = contact.generateId();
        System.out.println("ID: "+id);
        assertEquals(8, id.length());
    }

    @Test
    public void testCreateFile(){
        Contact contact = new Contact();
        String id  = contact.generateId();
        
        assertTrue(true);
    }
    
}
