package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {

	FileReader file = null;
	BufferedReader bf = null;
	String filename = null;
	
	// parameterized constructor to initialize filename
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {
		
		this.filename=fileName;
		file = new FileReader(filename);
		bf = new BufferedReader(file);
				
	}

	/*
	 * implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file.
	 * Note: Return type of the method will be Header
	 */
	@Override
	public Header getHeader() throws IOException {
		file = new FileReader(filename);
		bf = new BufferedReader(file);
		Header finalheader = new Header();
		// read the first line
		String headers = bf.readLine();
		//populate the header object with the String array containing the header names
						
		String [] headerArray = headers.split(",");
		
		finalheader.setHeaders(headerArray);
		
		return  finalheader;
	}

	/**
	 * getDataRow() method will be used in the upcoming assignments
	 */
	@Override
	public void getDataRow() {
		
		
	}

	/*
	 * implementation of getColumnType() method. To find out the data types, we will
	 * read the first line from the file and extract the field values from it. If a
	 * specific field value can be converted to Integer, the data type of that field
	 * will contain "java.lang.Integer", otherwise if it can be converted to Double,
	 * then the data type of that field will contain "java.lang.Double", otherwise,
	 * the field is to be treated as String. 
	 * Note: Return Type of the method will be DataTypeDefinitions
	 */
	@Override
	public DataTypeDefinitions getColumnType() throws IOException {
		file = new FileReader(filename);
		bf = new BufferedReader(file);
		
		DataTypeDefinitions finaloutput = new DataTypeDefinitions();
		
		String headers = bf.readLine();
		
		String [] headerArray = headers.split(",");
		
		String firstline = bf.readLine();
				
		String [] firstlineArray = firstline.split(",");
		
		
		String[] datatypes = new String[headerArray.length];
		
		for(int index = 0; index<headerArray.length; index++)
		{
			try
	        {
	            
	            datatypes[index]= classType(firstlineArray[index]);
	        }
	        catch(ArrayIndexOutOfBoundsException e)
	        {
	        	 datatypes[index]= classType(" ");
	            
	        }
		 
		}
		finaloutput.setDatatypes(datatypes);
		
		
		return finaloutput;
	}
	
	public String classType(String temp)
    {
        try
        {
            Integer t= Integer.parseInt(temp);
            return t.getClass().getName();
        }
        catch(Exception e)
        {
            String t= temp;
            return t.getClass().getName();
            
        }
    }
}
