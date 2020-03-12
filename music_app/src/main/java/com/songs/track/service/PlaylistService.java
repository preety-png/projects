/**
 * 
 */
package com.songs.track.service;
import java.util.List;

import com.songs.track.model.Playlist;
import com.songs.track.model.Songs;
import com.songs.track.model.Tags;


public interface PlaylistService {
	
	//get all playlist
	  public List<Playlist> getAllPlaylist();
	      	
	   // create  playlist
	     public Playlist createPlaylist(Playlist playlist);
	   
	   // create  delete playlist 
	     public boolean deletePlaylistById(Long id);
	   
	   // get  playlist by id 
	     public Playlist getPlaylistById(Long id);
	   
	 //   get  songs from playlist
	   List<Songs> explorePlaylistSongs(long playlistID);

}
