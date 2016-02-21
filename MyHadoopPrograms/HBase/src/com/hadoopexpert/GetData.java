package com.hadoopexpert;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class GetData {

	/**
	 * @author Syed
	 */
	public static void main(String[] args) throws IOException {
		// Instantiate Configuration Class
		Configuration cfg = HBaseConfiguration.create();

		// Instantiate HTable Class
		HTable hTable = new HTable(cfg, "employee");
		
		// get 'employee', 'Row1','personal'
		// get 'employee', 'Row1', 'professional'
		
		// get 'employee', Row1', 'personal:name'
		// get 'employee', 'Row1', 'professional:role'
		
		//Instantiate the Get class
		Get get = new Get(Bytes.toBytes("Row1"));
		get.addFamily(Bytes.toBytes("personal"));
		get.addFamily(Bytes.toBytes("professional"));
		
		//Reading the data
		Result result = hTable.get(get);
		
		//Execute from terminal using below command		
		//hadoop jar jarfile_path com.hadoop.GetData
		
		//Reading values from ResultSet Object
		byte [] value1 = result.getValue(Bytes.toBytes("personal"), Bytes.toBytes("name"));
		byte [] value2 = result.getValue(Bytes.toBytes("professional"), Bytes.toBytes("role"));
		
		
		
		//Printing the values			
		String name = Bytes.toString(value1);
		String role = Bytes.toString(value2);
		
		//System.out.println("name : " + value1 + " " + "role " + value2);
		System.out.println("Name : " + name + " " + "Role : " + role);
		
		
		
		
		
		
		
		
		
		

	}

}
