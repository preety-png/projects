/**
 * 
 */
package com.songs.track.service;

import java.util.List;

import com.songs.track.model.Playlist;
import com.songs.track.model.Tags;

public interface TagsService {

	// get all tags
	public List<Tags> getAllTags();

	// create tags
	public Tags createTag(Tags tag);

	// create delete tag
	public boolean deleteTagById(Long id);

	// get tag by id
	public Tags getTagById(Long id);
	
	public List<Playlist> exploreTagedPlaylist(List<Integer> ids);


}
