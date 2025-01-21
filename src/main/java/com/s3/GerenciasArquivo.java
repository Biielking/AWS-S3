package com.s3;

public class GerenciasArquivo {

	public static void main(String[] args) {
		//manipuladorBucket(): Implementação futura. function para o bucket.
		UploadFiles();
		DeleFiles();
	}
	
	private static void UploadFiles() {
		var operacoesS3 = new OperacoesS3();
		var nomeBucket = "maxebook";
		var origemArquivo = "C:\\Users\\User\\Downloads\\Revisao_prova.pdf";
		var destinoArquivo = "Documentos/Revisao_prova.pdf";
		operacoesS3.uploadFile(nomeBucket, destinoArquivo ,origemArquivo);
	}	
	
	private static void DeleFiles() {
		var operacoesS3 = new OperacoesS3();
		var nomeBucket = "maxebook";
		var destinoArquivo = "Documentos/Revisao_prova.pdf";

		operacoesS3.deletFile(nomeBucket, destinoArquivo);
	}	
}