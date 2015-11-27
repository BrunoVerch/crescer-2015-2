package br.com.cwi.crescer.lavanderia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cwi.crescer.lavanderia.DAO.UsersDAO;
import br.com.cwi.crescer.lavanderia.domain.Users;
import br.com.cwi.crescer.lavanderia.domain.Users.EnableUser;
import br.com.cwi.crescer.lavanderia.dto.UserDTO;

@Service
public class UsersService {

	private UsersDAO usersDao;
	
	@Autowired
	public UsersService(UsersDAO usersDao){
		super();
		this.usersDao = usersDao;
	}
	
	public Users findByUsername(String username){
		return this.usersDao.findByUsername(username);
	}
	
	public List<UserDTO> listarUsersAtivos() {
        List<Users> users = usersDao.findByEnables(EnableUser.ATIVO);

        List<UserDTO> dtos = new ArrayList<UserDTO>();

        for (Users user : users) {
            dtos.add(new UserDTO(user));
        }

        return dtos;
    }
	
	public List<UserDTO> listarTodos() {
        List<Users> users = usersDao.findAll();

        List<UserDTO> dtos = new ArrayList<UserDTO>();

        for (Users user : users) {
            dtos.add(new UserDTO(user));
        }

        return dtos;
    }
	
	public void excluir(String username) {
		Users entity = usersDao.findByUsername(username);
        entity.setEnabled(EnableUser.INATIVO);
        usersDao.save(entity);
    }
}
