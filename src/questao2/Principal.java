/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Matheus
 */
public class Principal {

    public static void main(String[] args){
        
        try{
            
        RandomAccessFile f1 = new RandomAccessFile("arquivo3.dat", "r");
        RandomAccessFile f2 = new RandomAccessFile("arquivo4.dat", "rw");
        
            long ultimoRegistro = (f1.length() / 102) - 1;
            long primeiro = 0;

            while (ultimoRegistro >= primeiro) {
                Registro e = new Registro();
                f1.seek(ultimoRegistro*102);
                e.leRegistro(f1);
                if(terminaCom(e.getEmail(),"gmail.com"))
                    e.escreveRegistro(f2);
                ultimoRegistro--;

            }

            f1.close();
            f2.close();

        } catch (Exception e) {
            System.err.println("Foi encontrado algum erro no sistema.\n");
            System.exit(1);
        }
    }
    
    public static boolean terminaCom(String email, String termina){
        return email.contains(termina);
    }
    
}