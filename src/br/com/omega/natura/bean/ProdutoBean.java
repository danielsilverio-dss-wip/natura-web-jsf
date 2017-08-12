package br.com.omega.natura.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.omega.natura.entity.Produto;
import br.com.omega.natura.repository.ProdutoRepository;

@ManagedBean
public class ProdutoBean {
	
	private Produto produto;
	private ProdutoRepository repository;
	
	@PostConstruct
	private void Init(){
		produto = new Produto();
		repository = new ProdutoRepository();
	}
	
	public String save(){
		
		FacesMessage msg;
		try {
			repository.save(produto);
			msg = new FacesMessage("Cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro!");
			
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "produto?faces-redirect=true";
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	

}
