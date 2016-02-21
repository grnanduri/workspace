package com.hadoopexpert;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class DeleteColumnFamily {

	/**
	 * @author Syed	
	 */
	public static void main(String[] args) throws IOException {
		//Instantiate Configuration Class
		  Configuration cfg = HBaseConfiguration.create();
		
		//Instantiate HBaseAdmin Class
		  HBaseAdmin admin = new HBaseAdmin(cfg);
		  
		  admin.deleteColumn("employee", "ContactDetails");
		  System.out.println("ColumnFamily Deleted from the table");
		  
		

	}

}
