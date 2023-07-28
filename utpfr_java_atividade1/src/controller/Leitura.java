package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {
    
    /**
     * @author Prof. José Antonio Gonçalves
     * @param rotulo
     * @return Input de usuário no terminal.
     */
    public String entDados(String rotulo) {

        System.out.println(rotulo);

        InputStreamReader teclado = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(teclado);
        
        String ret ="";
            
        try{
            ret = buff.readLine();
        }
        catch(IOException ioe){
            System.out.println("\nERRO de sistema: RAM - TECLADO");
        }

        return ret;
    }
}
