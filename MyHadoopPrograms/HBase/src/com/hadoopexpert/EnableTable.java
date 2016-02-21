package com.hadoopexpert;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class EnableTable {

	/**
	 * @author Syed
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//Instantiate Configuration Class
		  Configuration cfg = HBaseConfiguration.create();
		
		//Instantiate HBaseAdmin Class
		  HBaseAdmin admin = new HBaseAdmin(cfg);
		  
		// Verify whether the table is enable or not
		  boolean b = admin.isTableEnabled("employee");
		  System.out.println(b);
		  //Enable Table
		  if(!b){
			  admin.enableTable("employee");
			  System.out.println("Table Enabled");
		  }

	}

}
