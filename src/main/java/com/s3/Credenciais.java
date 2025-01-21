package com.s3;

public class Credenciais {
	
//	public static final String ACCESS_KEY = "";
//	public static final String SECRET_KEY = "";
	
	//CHAVES DE ACESSO CONFIGURADA NA MAQUINA/ 
	public static String getAccessKey() { 
		return System.getenv("AWS_ACCESS_KEY");
	}
	
	public static String getSecretKey() {
		return System.getenv("AWS_SECRET_KEY");
	}
}