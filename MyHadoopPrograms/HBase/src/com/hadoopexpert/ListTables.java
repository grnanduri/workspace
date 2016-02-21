package com.hadoopexpert;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class ListTables {

	/**
	 * @author Syed 	
	 */
	public static void main(String[] args) throws IOException {
		
		//Instantiate Configuration Class
		  Configuration cfg = HBaseConfiguration.create();
		
		//Instantiate HBaseAdmin Class
		  HBaseAdmin admin = new HBaseAdmin(cfg);
		  
		//Get all the List of the tables using HBASEAdmin Command
		  HTableDescriptor[] tableDescriptor = admin.listTables();		  
		  
		  //Printing all the table names
		  
		  for(int i = 0; i < tableDescriptor.length; i++){
		  //System.out.println(tableDescriptor[i]);
		  System.out.println(tableDescriptor[i].getNameAsString());
		  
		  
		  }
		  
		  
		  
		  
	}

}
