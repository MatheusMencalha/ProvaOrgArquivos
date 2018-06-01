/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Matheus
 */
public class Principal {

    public static void main(String[] args) throws Exception {
        RandomAccessFile f1 = new RandomAccessFile("arquivo5.dat", "r");
        RandomAccessFile f2 = new RandomAccessFile("arquivo6.dat", "r");
        RandomAccessFile f3 = new RandomAccessFile("arquivo7.dat", "rw");
        
        long ultimoRegistro = (f1.length() / 102) - 1;
        long primeiro = 0;
        System.out.println(f1.length() + "" + f2.length());

        while (ultimoRegistro != primeiro) {
            Registro e = new Registro();

            f1.seek(ultimoRegistro * 102);

            e.leRegistro(f1);

            boolean teste = buscaBinariaRecursiva(f2, 0, ultimoRegistro, e.getChave());
            if (teste) {
                
                
                e.escreveRegistro(f3);
                
            }

            ultimoRegistro--;

        }

        f1.close();
        f2.close();
        f3.close();

    }

    public static boolean buscaBinariaRecursiva(RandomAccessFile dados, long esq, long dir, String chave) throws Exception {
        long meio = (esq + dir) / 2;
        Registro ler = new Registro();

        System.out.println("CHAVE LINHA ATUAL-->>>" + chave);
        dados.seek(meio * 102);

        ler.leRegistro(dados);

        System.out.println("------" + ler.getChave() + ler.getNome() + ler.getEmail() + ler.getTelefone());

        String chaveLinhaAtual = ler.getChave();

        int a = Integer.parseInt(chaveLinhaAtual);
        int b = Integer.parseInt(chave);

        if (esq > dir) {
            return false;
        } else if (chaveLinhaAtual.equals(chave)) {
            System.out.println("É IGUAL "+chaveLinhaAtual+"====="+chave );
            return true;

        } else if (a < b) {
            return buscaBinariaRecursiva(dados, meio + 1, dir, chave);

        } else {
            return buscaBinariaRecursiva(dados, esq, meio - 1, chave);
        }
    }
}