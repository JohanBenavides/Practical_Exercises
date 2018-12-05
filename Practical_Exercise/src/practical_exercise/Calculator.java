package practical_exercise;
/**
 * @author Johan Shneider Benavides Arias
 */
import java.io.*;
public class Calculator {
//global buffer because it is used in functions    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static String Default      = "\033[39m";
    static String Red          = "\033[31m";
    static String Green        = "\033[32m";
    static String Blue         = "\033[34m";

    
    public int sum (int a, int b)//function sum, receives two addends as parameters and returns the sum of them
    {
     return a+b;//"a" and "b" are addends
    }
    
    public int subtraction (int a, int b)//function subtracts, receives a minuend and a subtrahend as parameters and returns the difference
    {
     return a-b;//"a" is the minuend and "b" the subtrahe
    }
    
    public int multiplication (int a, int b)//multiplication function, receives two numbers as parameters, returns the multiplication of them
    {
     if ( b==1){ //base case
        return a;}
     else { 
         return a+multiplication(a,b-1);//the multiplication is obtained by recursion, "a" and "b" are the factors of multiplication                    
         }
    }
    
    public int  division (int a, int b)//division function, receives two numbers as parameters "a" is the dividend and "b" is the divisor, returns the quotient of the division
    {
     if (b==0){//in the case of indetermination returns 0
     return 0;}        
     else if(a<b){//base case
       return 0;}          
     else{ return 1+division(a-b,b);}//the division is obtained by recursion              
    }
    
    public int power (int a, int b)//power function, receives two numbers as parameters "a" is the base and "b" is the exponent, returns the power
    {
     if(b==0){//base case
       return 1;}
     else{ return a*power(a,b-1);}//power obtained through recursion
    }
    
    public double square (int a)//square function, receives as a parameter a number whose square root is calculated
    {     
     return Math.sqrt(a);//The class Math contains methods for performing basic numeric operations such as the elementary exponential, logarithm, square root, and trigonometric functions.
    }
    
    public int residue (int a, int b)//residual function, receives two numbers as parameters "a" is the dividend and "b" is the divisor, returns the residual of the division
    {
     if(a<b){//base case
       return a;}           
     else{ return residue(a-b,b);}//residue obtained by recursion     
    }
    
    public int number (String regex)throws IOException//to not use try catch I used this method throws IOException
    {//function to request number 2
     
     bw.write("Digite el "+regex+" : ");
     bw.flush();                        
     String number = br.readLine();//number request
     int b = Integer.parseInt(number);//convert data type String to data type int   
     return b;//the number obtained is returned          
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Calculator f = new Calculator();//f to call the functions contained within the "Calculator" class
        
        int option,a,b; //variables
        
        try{
            do{//use the "do while" cycle, to repeat the menu until you decide to exit it with option 8 
                bw.write("\n"+Blue+".: OPERCIONES BÁSICAS:.\n\n");//menu
                bw.write(Blue+"1. Suma\n");
                bw.write(Blue+"2. Resta\n");
                bw.write(Blue+"3. Multiplicación\n");
                bw.write(Blue+"4. División\n");
                bw.write(Blue+"5. Potencia\n");
                bw.write(Blue+"6. Raíz cuadrada\n");
                bw.write(Blue+"7. Residuo de la División\n");
                bw.write(Blue+"8. Salir\n");
                bw.write(Blue+"\nOpción: "+Default);
                bw.flush();
            
                String op = br.readLine();//option request
                option = Integer.parseInt(op);//convert data type String to data type int
          
                switch(option){//Switch case is a control structure, It is used to streamline multiple decision making
                    
                  case 1: 
                  {
                    bw.write("\n"+Green+".: SUMA :.\n\n"+Default);                    
                    bw.flush();             
                    a = f.number("primer sumando");//the function "number" is called sending parameter "primer sumando"
                    b = f.number("segundo sumando");//the function "number" is called sending parameter "segundo sumando"                  
                    bw.write("\nLa suma de "+a+" + "+b+" es = "+f.sum(a,b)+"\n");//the function "sum" is called, sending the numbers "a" and "b" as parameters
                  } 
                    break;//the use of this statement breaks the iteration of said loop
                    
                  case 2:
                  {    
                    bw.write("\n"+Green+".: RESTA :.\n\n"+Default);
                    a = f.number("minuendo");//the function "num1" is called sending parameter "minuendo"
                    b = f.number("sustraendo");//the function "num2" is called sending parameter "sustraendo"                     
                    bw.write("\nLa diferencia de "+a+" - "+b+" es = "+f.subtraction(a,b)+"\n");//the function "subtraction" is called and it is sent as parameters "a" and "b"                
                  }
                    break;//the use of this statement breaks the iteration of said loop
                    
                  case 3:   
                  {
                    bw.write("\n"+Green+".: MULTIPLICACIÓN :.\n\n"+Default);   
                    a = f.number("primer factor");//the function "number" is called sending parameter "primer factor"
                    b = f.number("segundo factor");//the function "number" is called sending parameter "segundo factor"
                    bw.write("\nEl producto de: "+a+" x "+b+" es = "+f.multiplication(a,b)+"\n");//the function "multiplication" is called and sent as parameters "a" and "b"
                  } 
                    break;//the use of this statement breaks the iteration of said loop
                    
                  case 4: 
                  {      
                    bw.write("\n"+Green+".: DIVISIÓN :.\n\n"+Default);                    
                    a = f.number("dividendo");//the function "number" is called sending parameter "dividendo"
                    b = f.number("divisor");//the function "number" is called sending parameter "divisor"                                  
                    bw.write("\nEl cociente de "+a+" ÷ "+b+" es = "+f.division(a,b)+"\n");//the function "division" is called and sent as parameters "a" and "b"
                  } 
                    break;//the use of this statement breaks the iteration of said loop
                    
                  case 5: 
                  {     
                    bw.write("\n"+Green+".: POTENCIA :.\n\n"+Default);
                    bw.flush();
                    a = f.number("número base");//the function "number" is called sending parameter "número base"
                    b = f.number("exponente");//the function "number" is called sending parameter "exponente"
                    bw.write("\nLa potencia de "+a+" elavado a la "+b+" es: "+f.power(a,b)+"\n");//the function "power" is called and sent as parameters "a" and "b"                                       
                  }     
                    break;//the use of this statement breaks the iteration of said loop
                    
                  case 6: 
                  {    
                    bw.write("\n"+Green+".: RAÍZ CUADRADA :.\n\n"+Default);
                    a = f.number("número");//the function "number" is called sending parameter "número"              
                    bw.write("\nLa raíz cuadrada de "+a+" es : "+f.square(a)+"\n");//the function "square" is called and sent as parameter "a"
                  }      
                    break;//the use of this statement breaks the iteration of said loop
                    
                  case 7: 
                  {      
                    bw.write("\n"+Green+".: RESIDUO DE LA DIVISIÓN :.\n\n"+Default);                    
                    a = f.number("dividendo");//the function "number" is called sending parameter "dividendo"
                    b = f.number("divisor");//the function "number" is called sending parameter "divisor"              
                    bw.write("\nEl residuo de la división de "+a+" ÷ "+b+" es: "+f.residue(a,b)+"\n");//the function "residue" is called and sent as parameters "a" and "b"
                  } 
                    break;//the use of this statement breaks the iteration of said loop
                    
                  default: if (option!=8){//if the default case is different from 8 the option is not valid
                    bw.write("\n"+Red+"¡OPCIÓN NO VALIDA!\n"+Default);}                  
                  }
        
            }while(option!=8);//condition of the "do while" cycle           

        }catch (IOException ex){}
        
    }
       
}
