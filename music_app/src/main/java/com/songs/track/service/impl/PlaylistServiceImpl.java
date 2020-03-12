/**
 * 
 */
package com.songs.track.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songs.track.dao.impl.PlaylistDaoImpl;
import com.songs.track.model.Playlist;
import com.songs.track.model.Songs;
import com.songs.track.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService {
	
	@Autowired
	private PlaylistDaoImpl playlistDao;

	@Override
	public List<Playlist> getAllPlaylist() {
		return playlistDao.getAll();
	}

	@Override
	public Playlist createPlaylist(Playlist playlist) {
		return playlistDao.save(playlist);
	}

	@Override
	public boolean deletePlaylistById(Long id) {
		Playlist play = new Playlist();
		play.setPlaylist_id(id);
		return playlistDao.delete(play);
	}

	@Override
	public Playlist getPlaylistById(Long id) {
		return playlistDao.get(id);
	}


	@Override
	public List<Songs> explorePlaylistSongs(long playlistId) {
		return playlistDao.getSongsFromPlaylist(playlistId);
	}

}
