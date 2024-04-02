package test;

import java.sql.Connection;

import Metier.SingletonConnection;

public class App {
	public static void main(String[] args) {
		SingletonConnection.getConnection();
	}
}
