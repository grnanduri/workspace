package com.hadoopexpert;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.util.Bytes;

public class DeleteData {

	/**
	 * @author Syed
	 */
	public static void main(String[] args) throws IOException {
		// Instantiating Configuration class
		Configuration conf = HBaseConfiguration.create();
		
		// Instantiating HTable class
		HTable hTable = new HTable(conf, "employee");
		
		//Instantiate the Delete Class
		Delete delete = new Delete(Bytes.toBytes("Row1"));	
		
		
		//delete.deleteColumn(Bytes.toBytes("personal"), Bytes.toBytes("name"));
		 delete.deleteFamily(Bytes.toBytes("personal"));
		//delete.deleteColumn(Bytes.toBytes("professional"), Bytes.toBytes("role"));
		//delete.deleteColumns(Bytes.toBytes("professional"), Bytes.toBytes("salary"));
		
	
		//deleting the data
		hTable.delete(delete);
		
		//Closing the HTable Object
		hTable.close();
		
		System.out.println("Data Deleted");
		
		
		
		
		

	}

}
