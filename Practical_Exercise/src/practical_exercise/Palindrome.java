package practical_exercise;
import java.io.*;
/**
 *
 * @author Johan Shneider Benavides Arias
 */
public class Palindrome {    
      
    public boolean palindrome (String input)//the "palindrome" function receives a String parameter and returns a Boolean data type
    {
        if(input.length()<=1){//base case
          return true;
        }else if(input.charAt(0)==input.charAt(input.length()-1)){//compares the first and last character of the String
                return palindrome(input.substring(1,input.length()-1));//generates new string, removing first and last character from the original string
              }
        else return false;//If the conditions are not met it is not palindrome and return false         
    }     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        Palindrome f = new Palindrome();//f to call the functions contained within the "Palindrome" class
        
        try{
            bw.write("Ingrese una palabra: ");//String request
            bw.flush();
            String input = br.readLine();            
            input = input.replace(" ","");//spaces are omitted in a new String
            
            if ((f.palindrome(input))==true){//the function "palindrome" is called, and if it meets the condition it is palindrome
                bw.write("\n¡ES PALINDROMO!\n");
            } else bw.write("\n¡NO ES PALINDROMO!\n");
            
            
            bw.flush();
        }catch (IOException ex){}
    }
    
}
