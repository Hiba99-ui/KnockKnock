
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class KnockKnockServer {

    public static void main(String[] args) throws IOException {
       try {
            int port=1100;
            ServerSocket sersoc = new ServerSocket (port) ;
            System.out.println ("serveur active sur port " + port) ; 
            
            HashMap<String,String> jokes=new HashMap<String,String>();
            
            jokes.put("Goliath", "Goliath down, you look-eth tired!");
            jokes.put("Broccoli", "Broccoli doesn’t have a last name, silly.");
            jokes.put("Boo", "Why are you crying?");
            int l=jokes.size();
            ArrayList<String> jokeList=new ArrayList<String>();
            jokeList.addAll(jokes.keySet());
            
            while (true){
                
                Socket soc = sersoc.accept();
                InputStream flux = soc.getInputStream ();
                BufferedReader entree = new BufferedReader (new InputStreamReader (flux)) ;
                
                OutputStream flux1 = soc.getOutputStream();
                OutputStreamWriter sortie1 = new OutputStreamWriter (flux1);
                Boolean clientHere=true;
                
                String message = entree.readLine() ;
                
                
                while(clientHere){
                    if(message.equals("1")){
                        
                        sortie1.write("KnockKnock !\n");
                        sortie1.flush();
                        
                        String reponse1=entree.readLine();
                        System.out.println(reponse1);
                        
                        int v=(int)(Math.random()*l);
                        sortie1.write(jokes.keySet().toArray()[v]+"\n");
                        sortie1.flush();                  
                        
                        reponse1=entree.readLine();
                        System.out.println(reponse1);
                        
                        sortie1.write(jokes.get(jokeList.get(v))+"\n");
                        sortie1.flush();
                        
                       
                        
                    }else if(message.equals("2")){
                        
                        sortie1.write("Ready !\n");
                        sortie1.flush();
                        
                        String reponse1=entree.readLine();
                        System.out.println(reponse1);
                        
                        sortie1.write("Who's there\n");
                        sortie1.flush();
                        
                        String reponseClient1=entree.readLine();
                        System.out.println(reponseClient1);
                        
                        sortie1.write(reponseClient1+"Who ?\n");
                        sortie1.flush();
                        
                        String reponseClient2=entree.readLine();
                        jokes.put(reponseClient1, reponseClient2);
                        
                        
                    }else{
                        clientHere=false;
                        
                    }
                }
                soc.close();
            }   } catch (IOException ex) {
                System.out.println("Fin");
        }
    }
    
}
