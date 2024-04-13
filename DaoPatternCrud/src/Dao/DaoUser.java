package Dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DaoUser implements IDaoUser{

	private Connection con;
	
	public DaoUser() {
		con = ConnectionManager.getInstance().getConnection();
	}
	
	@Override
	public List<User> getAllUsers()  {
		List <User> users = new ArrayList<User>();
		String query = "select * from users;";
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String password  = rs.getString(4);
				User u = new User(id,name,age,password);
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public User getUser(int id) {
		String query = "select * from users where id = "+id+";";
		Statement st;
		User u = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
            if(rs.next()) {
            	int idu = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String password  = rs.getString(4);
				u = new User(idu,name,age,password);

            }
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public boolean addUser(User u) {
		String query = "Insert into users(id,name,age,password) values(?,?,?,?);";
		int rs = 0;
        if(getUser(u.getId())==null) {
        	PreparedStatement st;
			try {
				st = con.prepareStatement(query);
				st.setInt(1, u.getId());
	        	st.setString(2, u.getName());
	        	st.setInt(3, u.getAge());
	        	st.setString(4, u.getPassword());
	        	rs = st.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }else {
        	System.out.println("User with id : "+u.getId()+" already exists");
        }
		
		return rs >=0;
	}

	@Override
	public boolean updateUser(int id) {
		// TODO
		 return false;
	}

	@Override
	public boolean deleteUser(int id) {
        String query = "delete from users where id = ?;";
        int rs = 0;
        try {
        
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, id);
			rs = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return rs > 0 ;
	}

}
