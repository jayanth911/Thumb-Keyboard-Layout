import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class wordFrequency {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\jayan\\Desktop\\java Programs\\rawData.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st[] = br.readLine().split(" ");
        Scanner s = new Scanner(file);
        int n = st.length; 
        int arr[][] = new int[28][28];
        for(int i=0;i<n;i++)
        {
            String str=" ";
            str += st[i];
            str+=" ";
            str.toLowerCase();
            int prevIdx = 26;
            for(int j=1;j<str.length();j++)
            {
                int idx;
                if(str.charAt(j)==' ') idx=26;
                else if(str.charAt(j)<97||str.charAt(j)>122) idx = 27;
                else idx = str.charAt(j)-'a';
                arr[idx][prevIdx]++;
                prevIdx = idx;
            }
        }
        
        String matrix[][] = new String[28][56];
        int c = 0;
        Path fileName = Path.of( "outputData.txt");
        for(int i=0;i<28;i++)
        {
            ArrayList<ArrayList<Integer>> count = new ArrayList<>();
            for(int j=0;j<28;j++)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(1+j);
                temp.add(arr[j][i]+arr[i][j]);
                count.add(temp);
            }
            char convertedChar = (char)(i+97);
            System.out.println(convertedChar +"   : ");
            Collections.sort(count,(q,p)->p.get(1)-q.get(1));
            
            System.out.println(count);
            System.out.println();
            for(int j=0;j<28;j+=2) 
            { 
                matrix[j][c]=Integer.toString(count.get(j).get(0));
            }
            c++;
            for(int j=0;j<28;j+=2) 
            { 
                matrix[j][c]=Integer.toString(count.get(j).get(1));
            }
            c++;
        }
        
        
        
        //System.out.println("a | b | c | d | e | f | g | h | i | j | k | l | m | n | o | p | q | r | s | t | u | v | w | x | y | z |");
        // System.out.print("      ");
    //     for (int i = 97; i < 122; i++) {
    //     char convertedChar = (char)(i);
    //     System.out.print(convertedChar +"   | ");
    // }  
    
    
    // System.out.println();
    // for(int o=0;o<27;o++)
    // {
    //     char convertedChar = (char)(o+97);
    //     //System.out.print(convertedChar+" --> ");
    //         for(int l = 0 ; l<56;l++)
    //         {
    //             String temp = " ["+matrix[o][l]+"|"+matrix[o][l+1]+"] ";
    //             Files.writeString(fileName, temp);
    //             System.out.print(" ["+matrix[o][l]+"|");
    //             l++;
    //             System.out.print(matrix[o][l]+"] ");
    //         }
    //          System.out.println();
    //          Files.writeString(fileName, "\n");
    //         // System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
    //     }
    }
    // System.out.println();
    // for(int o=0;o<27;o++)
    //     {
    //         char convertedChar = (char)(o+97);
    //         System.out.print(convertedChar+" --> ");
    //         for(int l = 0 ; l<28;l++)
    //         {
    //             System.out.print(arr[o][l]+" | ");
    //         }
    //         System.out.println();
    //         System.out.println("------------------------------------------------------------------------------------------------------------");
    //     }
    // }
}
