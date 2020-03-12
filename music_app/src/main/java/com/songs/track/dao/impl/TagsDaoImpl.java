package com.songs.track.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.songs.track.dao.Dao;
import com.songs.track.model.Playlist;
import com.songs.track.model.Tags;

@Transactional
@Repository
public class TagsDaoImpl implements Dao<Tags> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Tags> getAll() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("SELECT e FROM Tags e");
		return query.getResultList();
	}

	@Override
	public Tags save(Tags tag) {
		entityManager.persist(tag);
		Long id = tag.getTag_id();
		return entityManager.find(Tags.class, id);

	}

	@Override
	public boolean delete(Tags t) {
		if (entityManager.contains(t))
			entityManager.remove(t);
		else
			entityManager.remove(entityManager.merge(t));

		return true;

	}

	@Override
	public Tags get(long id) {
		return entityManager.find(Tags.class, id);
	}
	
	//get playlist list from tags
	public List<Playlist> getPlaylistFromTags(List<Integer> tagsId) {
		String s ="(";
		
		for (int i:tagsId){
           s+=String.valueOf(i)+",";
        }
		
		s=(String) s.subSequence(0, s.length()-1)+")";
		
		Query query = entityManager.createQuery(" Select e FROM PlaylistAddSongAndTagging d INNER JOIN d.playlist e "
				+ "where d.tag_id in "+s);

		return query.getResultList();

	}



}
