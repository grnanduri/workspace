package com.hadoopexpert;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class DeleteTable {

	/**
	 * @author Syed
	 */
	public static void main(String[] args) throws IOException {
		// Instantiate Configuration Class
		Configuration cfg = HBaseConfiguration.create();

		// Instantiate HBaseAdmin Class
		HBaseAdmin admin = new HBaseAdmin(cfg);

		// Verify Whether Table is disabled or not
		boolean b = admin.isTableDisabled("employee");
		System.out.println(b);

		// If table is not disabled then disable it
		if (!b) {
			admin.disableTable("employee");
			System.out.println("Table Disabled");
			
			admin.deleteTable("employee");
			System.out.println("Table Deleted");

		}

	}

}
