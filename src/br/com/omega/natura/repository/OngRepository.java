package br.com.omega.natura.repository;

import java.awt.PageAttributes.MediaType;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.WebServiceException;

import org.apache.catalina.WebResource;

import com.sun.jersey.api.client.ClientResponse;


public class OngRepository {

		private static final String URL = "http//10.20.24.27:8081/ong/";
		
		private Client client = Client.create();
		
		public List<Ong> listar() throws Exception{
			WebResource resource = client.resource(URL);
			
			//Chama o webservice
			ClientResponse response = resource.accept(
				MediaType.APPLICATION_JSON)
					.get(ClientResponse.class);
			
			//Valida se deu certo a busca 
			if (response.getStatus() != 200){
				throw new WebServiceException("Http Status: " + 
						response.getStatus());
			}

			//Recupera a resposta do servidor
			Ong[] array = 
					response.getEntity(Ong[].class);
			return Arrays.asList(array);
		}
		
		public Ong buscar(int codigo) throws Exception{
			WebResource resource = client.resource(URL + codigo);
			
			ClientResponse response = resource
					.accept(MediaType.APPLICATION_JSON)
					.get(ClientResponse.class);
			
			if (response.getStatus() != 200){
				throw new WebServiceException("Http Status: " +
						response.getStatus());
			}
			return response.getEntity(Ong.class);
		}
		
		public void cadastrar(Ong ong) throws xception{
			WebResource resource = client.resource(URL);
			
			ClientResponse response = resource
					.type(MediaType.APPLICATION_JSON)
					.post(ClientResponse.class,ong);
			
			if (response.getStatus() != 201){
				throw new WebServiceException("Http Status: " +
						response.getStatus());
			}
		}
		
		public void atualizar(Ong ong) throws Exception{
			WebResource resource = client.resource(URL + ong.getCodigo());
			
			ClientResponse response = resource
					.type(MediaType.APPLICATION_JSON)
					.put(ClientResponse.class,ong);
			
			if (response.getStatus() != 200){
				throw new WebServiceException("HTTP Status: " +
						response.getStatus());
			}
		}
		
		public void remover(int codigo) throws Exception{
			WebResource resource = client.resource(URL + codigo);
			
			ClientResponse response = 
					resource.delete(ClientResponse.class);
			
			if (response.getStatus() != 204){
				throw new Exception("HTTP Status: " +
						response.getStatus());
			}
		}
		
	}