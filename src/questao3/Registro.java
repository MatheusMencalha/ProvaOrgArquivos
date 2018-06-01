/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao3;

import java.io.DataInput;
import java.io.DataOutput;
import java.nio.charset.Charset;

/**
 *
 * @author Matheus
 */
public class Registro {
    private String chave;
    private String nome;
    private String email;
    private String telefone;
    
    public void escreveRegistro(DataOutput dout) throws Exception{
        Charset enc = Charset.forName("ISO-8859-1");
        dout.write(this.chave.getBytes(enc));
        dout.write(this.nome.getBytes(enc));
        dout.write(this.email.getBytes(enc));
        dout.write(this.telefone.getBytes(enc)); 
        dout.write(" \n".getBytes(enc));
    }
    
    public void leRegistro(DataInput din) throws Exception{
        byte chave[] = new byte[8];
        byte nome[] = new byte[40];
        byte email[] = new byte[40];
        byte telefone[] = new byte[12];
        
        din.readFully(chave);
        din.readFully(nome);
        din.readFully(email);
        din.readFully(telefone);
        din.readByte();
        din.readByte();
        
        Charset enc = Charset.forName("ISO-8859-1");
        this.chave = new String(chave,enc);
        this.nome = new String(nome,enc);
        this.email = new String(email,enc);
        this.telefone = new String(telefone,enc);
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
