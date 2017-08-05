package br.com.omega.natura.repository;

import java.util.Arrays;
import java.util.List;

import com.sun.jersey.api.client.Client;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.WebServiceException;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.omega.natura.entity.Empresa;

public class EmpresaRepository {
	
	private static final String URL = "http://10.20.24.27:8081/empresa";
	
	private Client client =  Client.create();
	
	public List<Empresa> listar()throws WebServiceException{
		WebResource resource = client.resource(URL);
		
		//Chama Web service
		ClientResponse response = resource.accept(
				MediaType.APPLICATION_JSON)
					.get(ClientResponse.class);
			
			//Valida se deu certo a busca 
			if (response.getStatus() != 200){
				throw new WebServiceException("Http Status: " + 
						response.getStatus());
			}

			//Recupera a resposta do servidor
			Empresa[] array = 
					response.getEntity(Empresa[].class);
			return Arrays.asList(array);
		}
				
	public Empresa buscar(int codigo) throws WebServiceException{
		WebResource resource = client.resource(URL + codigo);
		
		ClientResponse response = resource
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		if (response.getStatus() != 200){
			throw new WebServiceException("Http Status: " +
					response.getStatus());
		}
		return response.getEntity(Empresa.class);
	}
	
	public void cadastrar(Empresa empresa) throws WebServiceException{
		WebResource resource = client.resource(URL);
		
		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class,empresa);
		
		if (response.getStatus() != 201){
			throw new WebServiceException("Http Status: " +
					response.getStatus());
		}
	}
	
	
	public void remover(int codigo) throws WebServiceException{
		WebResource resource = client.resource(URL + codigo);
		
		ClientResponse response = 
				resource.delete(ClientResponse.class);
		
		if (response.getStatus() != 204){
			throw new WebServiceException("HTTP Status: " +
					response.getStatus());
		}
	}
	
}