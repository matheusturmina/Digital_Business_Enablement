package br.com.fiap.bean;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;

@ManagedBean
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	
    public void save() {
    	
    	new UsuarioDao().save(this.usuario);
    	
        FacesContext.getCurrentInstance().addMessage(null,
        		new FacesMessage("Usuario cadastrado com sucesso\n"));
    }
    
    public List<Usuario> getUsuarios(){
    	return new UsuarioDao().getAll();
    }
    
    public void deletar() {
    	System.out.println("Fingindo que esta deletando ...");
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
