package Dao;

import java.util.List;

public interface IDaoUser{
	  List <User> getAllUsers();
	  User getUser(int id);
      boolean addUser(User u);
      boolean updateUser(int id);
      boolean deleteUser(int id);
}
