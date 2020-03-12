/**
 * 
 */
package com.songs.track.service;

import java.util.List;
import com.songs.track.model.PlaylistAddSongAndTagging;

public interface PlaylistAddingSongAndTaggingService {

	// get all user
	public List<PlaylistAddSongAndTagging> getSongAndTag();

	// create all user
	public PlaylistAddSongAndTagging addSongAndTags(PlaylistAddSongAndTagging user);

	// get user by id
	public PlaylistAddSongAndTagging getSongAndTaggingById(Long id);

}
