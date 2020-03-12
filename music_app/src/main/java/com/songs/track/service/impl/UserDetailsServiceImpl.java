/**
 * 
 */
package com.songs.track.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songs.track.dao.impl.UserDetailsDaoImpl;
import com.songs.track.model.Playlist;
import com.songs.track.model.UserDetails;
import com.songs.track.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsDaoImpl userDao;

	// get all user
	public List<UserDetails> getUserDetails() {
		return userDao.getAll();
	}

	// create user
	@Override
	public UserDetails createUserDetails(UserDetails user) {
		return userDao.save(user);
	}

	// delete user
	@Override
	public boolean deleteUserDetailsById(Long id) {
		UserDetails user = new UserDetails();
		user.setUser_id(id);
		return userDao.delete(user);
	}

	// get user
	@Override
	public UserDetails getUserDetailsById(Long id) {
		UserDetails user = userDao.get(id);
		return user;
	}

	@Override
	public List<Playlist> getUserPlayList(Long id) {
		return userDao.getPlaylist(id);
	}

}
