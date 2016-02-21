package com.hadoopexpert;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class InsertData {

	/**
	 * @author Syed
	 */
	public static void main(String[] args) throws IOException {

		// Instantiate Configuration Class
		Configuration cfg = HBaseConfiguration.create();

		// Instantiate HTable Class
		HTable hTable = new HTable(cfg, "employee");
		
		
		// put 'employee', 'Row1', 'personal:name', 'Zia'
		// put 'employee', 'Row1', 'personal:city', 'Bangalore'
		
		// put 'employee', 'Row1', 'professional:role', 'Manager'
		//put 'employee', 'Row1', 'professional:salary', '50000'

		
		
		//Instantiate Put Class and provide the Row Name
		Put put = new Put(Bytes.toBytes("Row1"));
		
		//Add Values using add(),  provide the ColumnFamily Name, ColumnQualifier Name and Value
		put.add(Bytes.toBytes("personal"), Bytes.toBytes("name"), Bytes.toBytes("Zia"));
		put.add(Bytes.toBytes("personal"), Bytes.toBytes("city"), Bytes.toBytes("Bangalore"));
		
		
		
		put.add(Bytes.toBytes("professional"), Bytes.toBytes("role"), Bytes.toBytes("Manager"));
		put.add(Bytes.toBytes("professional"), Bytes.toBytes("salary"), Bytes.toBytes("50000"));
		
				
		//Saving the Put Instance into HTable
		hTable.put(put);
		
		
		System.out.println("Table Data Inserted");
		//Closing the Table Connection
		hTable.close();
		
		
		
		
		
		
		
		

	}

}
