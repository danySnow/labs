import java.io.File;  
import java.util.Scanner; 
import java.io.FileWriter;
import java.io.FileNotFoundException; 
import java.io.IOException;

class mainone{

    char[] alphUp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    char[] alphD = "abcdefghijklmnopqrstuvqxyz".toCharArray();

    String HighLow = "high";

    public mainone(){
        creationOfAFile();

        for(int i = 0; i < 40; i++){
            System.out.print(nextOne());
        }
       
    }

    public static void main(String args[]){
        new mainone();
    }


    public void creationOfAFile(){
        try {

            File f = new File("txt1.txt");
            f.createNewFile();
            
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {

            FileWriter myWriter = new FileWriter("txt1.txt");
            myWriter.write("Files in Java might be tricky,\n but it is fun enough!");
            myWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
    
    int charCounter = -1;
    int lineNr = 0;

    public char nextOne(){
        charCounter++;
        try {
            File myObj = new File("txt1.txt");
            Scanner myReader = new Scanner(myObj);

            int n = 0;
            String data;
            char[] chars;

            do{
                data = myReader.nextLine();
                n++;

            }while(n < lineNr);

            chars = data.toCharArray();

            if(charCounter >= chars.length){
                lineNr++;
                charCounter = 0;
                
            }


            myReader.close();

            return chars[charCounter];
            
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return 'c';
    }


    public char toLower(char c){
        if(HighLow == "high"){
            for(int i = 0; i < alphD.length; i++){
                if(c == alphD[i]){
                    return alphUp[i];
                }
            }
        }else{
            for(int i = 0; i < alphUp.length; i++){
                if(c == alphUp[i]){
                    return alphD[i];
                }
            }
        }

       

        return c;
    }

}