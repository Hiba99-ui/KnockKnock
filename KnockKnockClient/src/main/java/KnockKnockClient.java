

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class KnockKnockClient {

    public static void main(String[] args) throws IOException {
        try {
            String hote = "127.0.0.1" ;
            int port = 1100 ;
            
            Socket soc = new Socket (hote, port) ;
            
            OutputStream flux = soc.getOutputStream();
            PrintWriter sortie = new PrintWriter (flux);
            
            InputStream flux1 = soc.getInputStream ();
            BufferedReader entree = new BufferedReader (new InputStreamReader (flux1)) ;
            
            
            System.out.println("veuillez choisir une activite");
            System.out.println("1)Tell");
            System.out.println("2)Learn");
            System.out.println("3)Quit");
            
            Scanner sc=new Scanner(System.in);
            String choix=sc.nextLine();
            sortie.write(choix+"\n");
            sortie.flush();
            

            if(choix.equals("1")){
                
                String response1=entree.readLine();
                System.out.println(response1);
                
                sortie.write("Who's there\n");
                sortie.flush();
                
                response1=entree.readLine();
                System.out.println(response1);
                
                sortie.write(response1+" Who ?\n");
                sortie.flush();
                
                response1=entree.readLine();
                System.out.println(response1);
                
            }else if(choix.equals("2")){
                String response1=entree.readLine();
                System.out.println(response1);
                
                sortie.write("KnockKnock !\n");
                sortie.flush();
                
                response1=entree.readLine();
                System.out.println(response1);
                
                String demande=sc.nextLine();
                sortie.write(demande+"\n");
                sortie.flush();
                
                response1=entree.readLine();
                System.out.println(response1);
                
                String suite=sc.nextLine();
                sortie.write(suite);
                sortie.flush();
            }else{
                soc.close();
            }
            sortie.flush();
        } catch (IOException ex) {
            System.out.println("Fin");
        }
    
    }
    
}
