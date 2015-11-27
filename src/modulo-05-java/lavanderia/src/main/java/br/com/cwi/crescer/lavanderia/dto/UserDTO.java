package br.com.cwi.crescer.lavanderia.dto;

import br.com.cwi.crescer.lavanderia.domain.Users;
import br.com.cwi.crescer.lavanderia.domain.Users.EnableUser;

public class UserDTO {

	private String username;
	private String password;
	private EnableUser enabled;


    public UserDTO() {
    }

    public UserDTO(String username, String password, EnableUser enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public UserDTO(Users entity) {
    	username = entity.getUsername();
    	password = entity.getPassword();
    	enabled = entity.getEnabled();
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EnableUser getEnabled() {
		return enabled;
	}

	public void setEnabled(EnableUser enabled) {
		this.enabled = enabled;
	}
    
    
}
