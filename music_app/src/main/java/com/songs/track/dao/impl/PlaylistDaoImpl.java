package com.songs.track.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.songs.track.dao.Dao;
import com.songs.track.model.Playlist;
import com.songs.track.model.Songs;


@Transactional
@Repository
public class PlaylistDaoImpl implements Dao<Playlist> {

	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public Playlist get(long id) {
		return entityManager.find(Playlist.class, id);
	}

	@Override
	public List<Playlist> getAll() {
		 Query query = entityManager.createQuery("SELECT e FROM Playlist e");
	     return query.getResultList();
	}

	@Override
	public Playlist save(Playlist playlist) {
		entityManager.persist(playlist);
	    Long id = playlist.getPlaylist_id();
	    return entityManager.find(Playlist.class, id);
		
	}

	@Override
	public boolean delete(Playlist id) {
		if (entityManager.contains(id))
			entityManager.remove(id);
		else
			entityManager.remove(entityManager.merge(id));

		return true;

	}
	//get songs list from playlist
	public List<Songs> getSongsFromPlaylist(Long playlistId) {
		Query query = entityManager.createQuery(" Select e FROM PlaylistAddSongAndTagging d INNER JOIN d.song e "
				+ "where d.playlist_id="+playlistId);

		return query.getResultList();
	}

	
}
