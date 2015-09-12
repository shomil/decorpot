package com.decorpot.repositories;

public class DatabaseList {
	String databaseName;

	public String getDatabaseName() {
		System.out.println("decorpot-services/DatabaseList:get");
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		System.out.println("decorpot-services/DatabaseList:set");
		this.databaseName = databaseName;
	}
}
