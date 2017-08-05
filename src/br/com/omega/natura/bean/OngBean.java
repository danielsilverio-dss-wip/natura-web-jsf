package br.com.omega.natura.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.omega.natura.entity.Ong;
import br.com.omega.natura.repository.OngRepository;

@ManagedBean
public class OngBean {
	
	private Ong  ong;
	OngRepository rep = new OngRepository();
	
	@PostConstruct
	private void init(){
		ong = new Ong();
		rep = new OngRepository();
	
		
	}

	public String save(){
		FacesMessage msg;
		try {
			rep.save(ong);
			msg = new FacesMessage("Cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro!");
			
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "ong?faces-redirect=true";
	}
	
	public Ong getOng(){
		return ong;
		
	}
	public void setOng(Ong ong) {
		this.ong = ong;
	}
}