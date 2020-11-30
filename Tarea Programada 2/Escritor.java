package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Escritor {

    public void escribir(String nombre, Ecuacion ecua1, Ecuacion ecua2, String operador, Ecuacion resultado){
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;



        try {
            f = new File(nombre);
            w = new FileWriter(f);
            bw = new BufferedWriter(w);
            wr = new PrintWriter(bw);

            wr.write(ecua1.aString()+"|"+operador+"|"+ecua2.aString()+"|"+resultado.aString());
            wr.append(" \n");


            wr.close();
            bw.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
