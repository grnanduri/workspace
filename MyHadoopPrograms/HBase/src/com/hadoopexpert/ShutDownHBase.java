package com.hadoopexpert;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class ShutDownHBase {

	/**
	 * @author Syed
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// Instantiate Configuration Class
		Configuration cfg = HBaseConfiguration.create();

		// Instantiate HBaseAdmin Class
		HBaseAdmin admin = new HBaseAdmin(cfg);
		
		//ShutDown HBase
		System.out.println("Shutting Down HBase");
		admin.shutdown();

	}

}
