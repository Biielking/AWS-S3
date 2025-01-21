package com.s3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.File;
//import java.util.List;
//import java.util.stream.Collectors;

public class OperacoesS3 {
	private final AmazonS3 clienteS3;
	
	public OperacoesS3() {
		var credenciais = new BasicAWSCredentials(Credenciais.getAccessKey(), Credenciais.getSecretKey());
		clienteS3 = AmazonS3ClientBuilder
					.standard()
					.withCredentials(new AWSStaticCredentialsProvider(credenciais))
					.withRegion(Regions.US_EAST_2)
					.build();
	}
	
	public void uploadFile(String nomeBucket, String destinoArquivo, String origemArquivo) {
		if(!clienteS3.doesBucketExistV2(nomeBucket)) {
			System.out.println("o bucket informado não existe, verifique por faovr ["+ nomeBucket + "].");
			return;
		}
		clienteS3.putObject(nomeBucket, destinoArquivo, new File(origemArquivo));
	}
		
//	METODO PARA SER ADICIONADO EXCLUIR BUCKET E FAZER UMA LISTAGEM 	
//	public void deletBucket(final String nomeBucket) {
//		if(!clienteS3.doesBucketExistV2(nomeBucket)) {
//			System.out.println("O bucket informado não existe [" + nomeBucket + ").");
//			return;
//		}
//		clienteS3.deleteBucket(nomeBucket);
//	}
	
	public void deletFile(String nomeBucket, String chaveArquivo) {
		clienteS3.deleteObject(nomeBucket, chaveArquivo);
	}
}