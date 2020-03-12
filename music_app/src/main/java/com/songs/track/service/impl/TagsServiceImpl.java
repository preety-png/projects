/**
 * 
 */
package com.songs.track.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songs.track.dao.impl.TagsDaoImpl;
import com.songs.track.model.Playlist;
import com.songs.track.model.Tags;
import com.songs.track.service.TagsService;


@Service
public class TagsServiceImpl implements TagsService {
	
	@Autowired
	private TagsDaoImpl tagDao;

	@Override
	public List<Tags> getAllTags() {
		return tagDao.getAll();
	}

	@Override
	public Tags createTag(Tags tag) {
		return tagDao.save(tag);
	}

	@Override
	public boolean deleteTagById(Long id) {
		Tags tag = new Tags();
		tag.setTag_id(id);
		return tagDao.delete(tag);
	}

	@Override
	public Tags getTagById(Long id) {
		return tagDao.get(id);
	}

	@Override
	public List<Playlist> exploreTagedPlaylist(List<Integer> tags) {
		return tagDao.getPlaylistFromTags(tags);
	
	}

	



}
