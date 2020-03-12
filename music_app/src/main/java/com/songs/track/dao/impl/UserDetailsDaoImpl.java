package com.songs.track.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.songs.track.dao.Dao;
import com.songs.track.model.Playlist;
import com.songs.track.model.UserDetails;

@Transactional
@Repository
public class UserDetailsDaoImpl implements Dao<UserDetails> {

	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public UserDetails get(long user_id) {
		return entityManager.find(UserDetails.class, user_id);
	}

	@Override
	public List<UserDetails> getAll() {
		 Query query = entityManager.createQuery("SELECT e FROM UserDetails e");
	     return query.getResultList();
	}

	@Override
	public UserDetails save(UserDetails user) {
		entityManager.persist(user);
	    Long id = user.getUser_id();
	    return entityManager.find(UserDetails.class, id);
		
	}

	@Override
	public boolean delete(UserDetails user) {
		if (entityManager.contains(user))
			entityManager.remove(user);
		else
			entityManager.remove(entityManager.merge(user));

		return true;

	}

	public List<Playlist> getPlaylist(Long id) {
		Query query = entityManager.createQuery(" Select e FROM UserDetails d INNER JOIN d.playlist e "
				+ "where d.user_id="+id);

		return query.getResultList();
	}

	
}
