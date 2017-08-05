package br.com.omega.natura.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.omega.natura.entity.Empresa;
import br.com.omega.natura.exception.DBException;
import br.com.omega.natura.repository.EmpresaRepository;

public class EmpresaBean {
	
	private Empresa empresa;
	
	private EmpresaRepository empRepository;
	
	@PostConstruct
	private void init(){
		empresa = new Empresa();
		empRepository = new EmpresaRepository();
	}
	
   public String cadastrar(){
	   FacesMessage msg;
	   try{
		   empRepository.cadastrar(empresa);
		   msg = new FacesMessage("Cadastrado!");
	   }catch (Exception e) {
		   e.printStackTrace();
			msg = new FacesMessage("Erro!");
	}
	   FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().setKeepMessages(true);
		return "empresa?faces-redirect=true";
   }

public Empresa getEmpresa() {
	return empresa;
}

public void setEmpresa(Empresa empresa) {
	this.empresa = empresa;
}

}
