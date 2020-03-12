/**
 * 
 */
package com.songs.track.service;

import java.util.List;

import com.songs.track.model.Playlist;
import com.songs.track.model.UserDetails;

public interface UserDetailsService {
	
// get all user
    public List<UserDetails> getUserDetails();
    
   	
 // create  all user 
    public UserDetails createUserDetails(UserDetails user);
  
 // create  delete user 
    public boolean deleteUserDetailsById(Long id);
  
// get  user by id 
    public UserDetails getUserDetailsById(Long id);
    
 //get user playlist   
    public List<Playlist> getUserPlayList(Long id);


}
