package asciii;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.Scanner;

public class asciiConversion {
	Scanner scan;
	File file;
	BufferedReader file_reader = null;
	FileInputStream input;
	FileWriter file_writer;
	BufferedWriter buffer_file_writer;	
	String line=null,stringbit="";
	int i=1,j=0,k=0,record=0,y=0,m=0;
	String records[] = null;
	String byteRecord[]=null;
	String asciiRecord[]=null;
	int flag=0,tile=0;
	char[] cArray=null;
	String ascii[]=null,s[]=null;
	BitSet bit=null;
	
	asciiConversion(){
		scan = new Scanner(System.in);
		file= new File("C://Users//aelay//workspace//GooGleIO//src//asciii//OutputAscii.txt"); //Information About the Output File
		System.out.println("Please enter the filename for Output:"); //Providing the file name for the output data.
		try{
			if(!file.exists()){
				file.createNewFile();
			}
		input = new FileInputStream("C://Users//aelay//workspace//GooGleIO//src//asciii//A-small-practice.in");
		file_reader = new BufferedReader(new InputStreamReader(input));
		file_writer = new FileWriter(file.getAbsoluteFile());
		buffer_file_writer = new BufferedWriter(file_writer);
		line = file_reader.readLine();
		System.out.println(""+line);
		record=Integer.parseInt(line);
		records = new String[2*record+1];
		byteRecord = new String[record];
		asciiRecord = new String[record];
		while(true){
			line = file_reader.readLine();
			if(line==null) break;
			if(flag%2==0){
				byteRecord[j]= line;
				j++;
			}
			if(flag%2==1){
				
				asciiRecord[k]=line.replaceAll("O","0");
				asciiRecord[k]=asciiRecord[k].replaceAll("I", "1");
				k++;
			}
			flag++;		
		}
		
		for(int l=0;l<record;l++){
			buffer_file_writer.write("Case #"+(l+1)+": ");
			tile= Integer.parseInt(byteRecord[l]);
			s= new String[tile];
			cArray= asciiRecord[l].toCharArray();
			m=0;
			for(int q=0;q<tile;q++){
				stringbit="";
				for(int w=0;w<8;w++){
					stringbit= stringbit+cArray[m];
					m++;
				}
				y= Integer.parseInt(stringbit,2);
				s[q] = String.valueOf((char)y);
				buffer_file_writer.write(s[q]);
			}
			buffer_file_writer.write("\n");
			
			
			
		}
		buffer_file_writer.close();
		file_reader.close();
					}catch(Exception e){
			e.printStackTrace();
		}
		
	
	}
	
	public static void main(String args[]){
		new asciiConversion();
	}

}
