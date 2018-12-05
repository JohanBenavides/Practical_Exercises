package practical_exercise;
import java.io.*;
/**
 *
 * @autor Johan Shneider Benavides Arias
 */
public class More_Repeated {
    //global buffer because it is used in functions 
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    
    public static int substring_occurences(String total, String sub)//function that receives as a parameter a string and a substring
    {
        int counter = 0;
        for(int i=0;i<=total.length()- sub.length();i++){//generation of all substrings of size "i" which is compared with substring
           if(total.substring(i,i+sub.length()).equals(sub)){//comparison of substrings
               counter +=1;//occurrence counter
           }
        }
        return counter;//occurrence counter
    }
    public static void all_substrings(String total) throws IOException
    {
        int max = 0;//winner's occurrence counter initialized 
        String winner = "";//String of "more repeated" initialized
        
        for(int i = 2;i<=total.length();i++){//substring size       
            for(int j = 0 ;j<=(total.length()-i);j++){//generation of all substrings
                //new substring = j beginIndex, j+i endIndex
                if(substring_occurences(total, total.substring(j,j+i))>=max)
                {//here is defined which chain was repeated more, keeping the substring in winner and its occurrence in max
                 max = substring_occurences(total, total.substring(j,j+i));
                 winner = total.substring(j, j+i);
                 //*if its occurrence is the greatest the substring that was compared in winner is saved and the times that it was repeated in max
                }
            }
        }
        bw.write("\nLa cadena que más se repite es "+winner+" y se repite "+max+" veces.");//result                      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        
        try{   
            bw.write("Ingrese una cadena de caracteres: \n\n");
            bw.flush();            
            String input = br.readLine();//String request
            More_Repeated.all_substrings(input);//function call
            bw.flush();
        }catch (IOException e){}
    }
    
}
