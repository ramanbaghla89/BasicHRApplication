package com.raman.data;

import com.raman.model.User;

public interface UserDAO {
	public void addUser(User user)throws Exception;
	public User getUser(String userID)throws Exception;

}
