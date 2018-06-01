/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao1;

import java.io.RandomAccessFile;

/**
 *
 * @author Matheus
 */
public class Principal {

    public static void main(String[] args){

        try{
            
        RandomAccessFile f1 = new RandomAccessFile("arquivo1.dat", "r");
        RandomAccessFile f2 = new RandomAccessFile("arquivo2.dat", "rw");

        long primeiro = 0;
        long ultimo = (f1.length() / 101) - 1;
        
        

        while (ultimo >= primeiro) {
            Registro a = new Registro();
            f1.seek(ultimo*101);
            a.leRegistro(f1);
            a.escreveRegistro(f2);
            ultimo--;
        }
        f1.close();
        f2.close();
        
        }catch(Exception e){
            System.err.println("Erro");
            System.exit(1);
        }
    }
}
