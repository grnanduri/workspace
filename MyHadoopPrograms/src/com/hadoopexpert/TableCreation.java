package com.hadoopexpert;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class TableCreation {

	public static void main(String[] args) throws IOException{
		
		
		// create 'employee', 'personal','professional'
		
		//Instantiate Configuration Class
		Configuration cfg = HBaseConfiguration.create();
		
		//Instantiate HBaseAdmin Class
		HBaseAdmin admin = new HBaseAdmin(cfg);
		
		//Instantiate Table Descriptor Class
		HTableDescriptor tableDescriptor = new HTableDescriptor("employee");
		
		//Adding ColumnFamilies to the Descriptor
		tableDescriptor.addFamily(new HColumnDescriptor("personal"));
		tableDescriptor.addFamily(new HColumnDescriptor("professional"));
		
		//Execute the table through admin
		admin.createTable(tableDescriptor);
		
		System.out.println("Table Created");
		
	}
	
	
}
