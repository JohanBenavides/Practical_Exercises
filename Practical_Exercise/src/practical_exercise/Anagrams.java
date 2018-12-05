package practical_exercise;
/**
 * @author Johan Shneider Benavides Arias
 */
import java.io.*;

public class Anagrams{
 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void combinations(String primero,String input) 
    {
    	if(input.length()==2)
    	{    	
            try{
    		bw.write(primero+input.charAt(1)+""+input.charAt(0));
                bw.write("\n");
    		bw.write(primero+input.charAt(0)+""+input.charAt(1));
                bw.write("\n");
                bw.flush();
            }catch (IOException ex){}
    	}
    	else{
    		for (int i=0;i<input.length();i++) {
    		   combinations(primero+input.charAt(i),remove_letter(input,i));
    		}
    	}
    }
    public static String remove_letter(String cadena,int i)
    {
    	if(i==0){
    		return cadena.substring(i+1,cadena.length());
    	}
    	else{
    		if(i==cadena.length()){
    	           return cadena.substring(0,cadena.length()-1);
    		}
    		else{
    		   return cadena.substring(0,i)+cadena.substring(i+1,cadena.length());
    		}
    	}
    }
     /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	try{
        
        bw.write("Digite una palabra:");
        bw.flush();
        String input=br.readLine();
    	combinations("",input);
    		
            }catch (IOException ex){} 
        
        
    }
}
