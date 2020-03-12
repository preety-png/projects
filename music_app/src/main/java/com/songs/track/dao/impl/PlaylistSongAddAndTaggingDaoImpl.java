package com.songs.track.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.songs.track.dao.Dao;
import com.songs.track.model.PlaylistAddSongAndTagging;

@Transactional
@Repository
public class PlaylistSongAddAndTaggingDaoImpl implements Dao<PlaylistAddSongAndTagging> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<PlaylistAddSongAndTagging> getAll() {
		Query query = entityManager.createQuery("SELECT e FROM PlaylistAddSongAndTagging e");
		return query.getResultList();
	}

	@Override
	public PlaylistAddSongAndTagging save(PlaylistAddSongAndTagging t) {
		entityManager.persist(t);
		long playlistMapping_id = t.getPlaylistmapping_id();
		return entityManager.find(PlaylistAddSongAndTagging.class, playlistMapping_id);

	}

	@Override
	public boolean delete(PlaylistAddSongAndTagging t) {
		if (entityManager.contains(t))
			entityManager.remove(t);
		else
			entityManager.remove(entityManager.merge(t));

		return true;
	}

	@Override
	public PlaylistAddSongAndTagging get(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(PlaylistAddSongAndTagging.class, id);
	}
	

}
