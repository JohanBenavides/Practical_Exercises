package practical_exercise;
import java.io.*;
/**
 *
 * @author Johan Snneider Benavides Arias
 */
public class Recursive_Functions {
    //global buffer because it is used in functions 
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    
public int Fibonacci (int n)//the "Fibonacci" function needs a parameter, return number of the fibonacci sequence according to the parameter
    {
        
        if(n<2){//base case        
            return n;
        }else{             
            return Fibonacci(n-1)+Fibonacci(n-2);//the fibonacci sequence is obtained by recursion according to the received parameter
          }
    }
    
    public long Factorial (int n)//the "Factorial" function needs a parameter, returns its factorial
    {
        if(n<1){//base case
            return 1;
        } else{
            return n*Factorial(n-1);//the factorial is obtained through recursion
          }
    }

    public static int Pascal (int a, int b)
    {
        if(b==0||b==a){//base case
            return 1;
        } else{
            return Pascal(a-1,b-1) + Pascal(a-1,b);//sum of variables specified from the previous row
          }
    }
    public int number ()throws IOException //to not use try catch I used this method throws IOException
    {//function to request number 1
        
     int n;
     bw.write("Digite un número: ");
     bw.flush();                        
     String numero1 = br.readLine();
     n = Integer.parseInt(numero1);//convert data type String to data type int   
     return n;//the number obtained is returned       
    }

    public static void main(String[] args) {
                
        Recursive_Functions f = new Recursive_Functions();//f to call the functions contained within the "Recursive_Functions" class
        
        int option,n;//variables
        
        try{
            do 
            { //use the "do while" cycle, to repeat the menu until you decide to exit it with option 4   
                bw.write("\n.: OPERACIONES :.\n\n");
                bw.write("1. Serie Fibonacci\n");
                bw.write("2. Factorial\n");
                bw.write("3. Triángulo de Pascal\n");
                bw.write("4. Salir\n");
                bw.write("\nOpción: ");
                bw.flush();
            
                String op = br.readLine();//option request
                option = Integer.parseInt(op);//convert data type String to data type int
                
                switch (option){//Switch case is a control structure, It is used to streamline multiple decision making
                    
                    case 1:
                    {
                      bw.write("\n.: FIBONACCI :. \n\n");
                      n=f.number();//the "number" function is called to obtain a number
                      bw.write("\nLos primeros "+n+" números de la Sucesión Fibonacci son: \n\n");//by means of the "for" cycle it is called the function "fibonacci" sending as parameter the "iteration"
                      for(int i=0;i<n;i++){
                         bw.write(f.Fibonacci(i)+" ");//by means of the cycle the "Fibonacci sequence" is obtained
                      }
                      bw.write("\n");//line break
                      bw.flush();
                    }
                    break;//the use of this statement breaks the iteration of said loop
                    
                    case 2:
                    {
                      bw.write("\n.: FACTORIAL :. \n\n");
                      n=f.number();//the "number" function is called to obtain a number
                      bw.write("\nEl factorial de "+n+" es: "+f.Factorial(n)+"\n");//the "factorial" function is called sending as parameter "n" 
                      bw.flush();
                    }
                    break;//the use of this statement breaks the iteration of said loop
                    
                    case 3:
                    {
                      bw.write("\n.: TRÍANGULO DE PASCAL :. \n\n");                                          
                      bw.flush();
                      n=f.number();//the "number" function is called to obtain a number
                      bw.write("\n");//line break
                       
                        for(int i=0; i<=n; i++)//nested cycle to generate positions in the triangle
                        {
                           for(int j=0; j <=i; j++)
                            
                            bw.write(Pascal(i,j)+" ");//the "pascal" function is called and returns the sum of Pascal (a-1, b-1) + Pascal (a-1, b)
                             bw.write("\n");//line break for new row
                              bw.flush();                            
                        }
                    }
                    break;//the use of this statement breaks the iteration of said loop
                    
                    default: if(option!=4){//if the default case is different from 8 the option is not valid
                        bw.write("\n¡OPCIÓN NO VALIDA!\n");
                    }                  
                    
                }                        
                
            }while (option!=4);//condition of the "do while" cycle 
        
        }catch (IOException ex){}
    }
    
}
