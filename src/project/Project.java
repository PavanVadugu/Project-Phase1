package project;

import java.io.*;
import java.util.Scanner;


public class Project 
{

	public static void main(String[] args) throws IOException
	{
		int i= 0;
		Project p = new Project();
		Scanner sc = new Scanner(System.in);
	
				//  *******************************************************************  //
				//  **********  THIS WILL DISPLAY ALL FILES AND DIRECTORIES  **********  //
				//  *******************************************************************  //
		
		{
		  System.out.println("Enter the path to display all files");
	      String folderPath = sc.next();
	      File folder = new File(folderPath);
	      
	      if (folder.isDirectory())
	      {
	         File[] listOfFiles = folder.listFiles();
	         if (listOfFiles.length < 1)
	        	 System.out.println("There is no File inside Folder");
	         else 
	         {
	         System.out.println("List of Files");
	         }
	         for (File file : listOfFiles) 
	         {
	            if(!file.isDirectory())
	            	System.out.println(file.getCanonicalPath().toString());
	         } 
	      } 
	      else {
	      System.out .print("There is no Folder @ given path :" + folderPath);
	      }
	   
		}
	
			      
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("======================================================================");
		System.out.println("||||||||||||||||||||           LOCKED ME          ||||||||||||||||||||");
		System.out.println("======================================================================");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("1.Add file");
		System.out.println("2.Delete");
		System.out.println("3.Search");
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("Enter Your Choice:");
		i = sc.nextInt();
		
		switch(i) 
		{
		case 1:System.out.println("Add file");
				p.NewFile();
				break;
		case 2:System.out.println("Delete");
				p.delete();
				break;
		case 3:System.out.println("Search");
				p.search();
				break;
		default:System.out.println("Please select correct choice");	
			break;
	    }
		sc.close();
}
	
    

			//  *******************************************************************  //
			//  *******************  THIS METHOD IS FOR  SEARCH  ******************  //
			//  *******************************************************************  //
	
	public void search()
	{
		String path = "", fileName = "";
	    try 
	    	{
	        	System.out.print("Please Enter the path-\t");
	        	BufferedReader filePathReader = new BufferedReader(new InputStreamReader(System.in));
	        	path = filePathReader.readLine();
	        	
	        	System.out.print("Please Enter file name-\t");
	        	BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
	        	fileName = fileNameReader.readLine();

	        	File directory = new File(path);
	        	File[] listOfFiles = directory.listFiles();
	        	for (File file : listOfFiles) 
	        		{
	                	String name = file.getName();
	                	if (name.equals(fileName)) 
	                		{
	                        	System.out.println(name + " found in " + path + " directory");                	
	                        	return;
	                		}
	        		}
	        	System.out.println(fileName + " not found in " + path + " directory");
	    	} 
	    catch (IOException e) 
	    	{e.printStackTrace();}
	}
	
		
				 		//  *******************************************************************  //
				 		//  ******************  THIS METHOD IS FOR DELETING  ******************  //
				 		//  *******************************************************************  //
		 
  	public void delete()
	{
  		try 
  		{
		 
		System.out.println("enter the file name u want to delete");
		Scanner n = new Scanner(System.in);
		String Filename = n.next();
		File file = new File(Filename); 
	    boolean b = file.delete();
		if(b==true) 
	    { 
	        System.out.println(file.getName() + " Successfully deleted"); 
	    } 
		else
     	{
	     System.out.println("File not found"); 
		 }
		n.close();
  		}
  		catch (Exception e) 
    	{
  			e.printStackTrace();
  			}
}	 
	
	
			//  *******************************************************************  //
			//  *************  THIS METHOD IS FOR CREATING A NEW FILE  ************  //
			//  *******************************************************************  //
	
	
	public void NewFile()
	{
		try
	{
		System.out.println("enter the file name u want add");
		Scanner scn = new Scanner(System.in);
		String Filename = scn.next();
		File file  = new File(Filename);
		
		
		if(file.createNewFile())
		{
			System.out.println("file is created");
		
		}
			else
		{
				if(file.exists())
    			{
                	System.out.println("File already exists.");	
                	System.out.println("File path:" + file.getAbsolutePath());
                	System.out.println("File name:  " + file.getName());
                	System.out.println("File class:  " + file.getClass());
                	System.out.println("File parent:  " + file.getParent());
                	System.out.println("File space allocated:  " + file.getUsableSpace());
                	System.out.println("File length: " + file.length());
                	System.out.println("File list:   " + file.list());
                
    			}
				 else
             	{
             		System.out.println("File doesnot exists.");
             	}
		}
		scn.close();		
	}

	catch(Exception e)
	{
		e.printStackTrace();

	}
	}	

}	