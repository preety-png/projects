/**
 * 
 */
package com.songs.track.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.songs.track.dao.impl.PlaylistSongAddAndTaggingDaoImpl;
import com.songs.track.model.PlaylistAddSongAndTagging;
import com.songs.track.service.PlaylistAddingSongAndTaggingService;

@Service
public class PlaylistAddingSongAndTaggingServiceImpl implements PlaylistAddingSongAndTaggingService {

	@Autowired
	private PlaylistSongAddAndTaggingDaoImpl songAndTagDao;

	@Override
	public List<PlaylistAddSongAndTagging> getSongAndTag() {
		return songAndTagDao.getAll();
	}

	@Override
	public PlaylistAddSongAndTagging addSongAndTags(PlaylistAddSongAndTagging songsAndTag) {
		return songAndTagDao.save(songsAndTag);
	}

	@Override
	public PlaylistAddSongAndTagging getSongAndTaggingById(Long id) {
		PlaylistAddSongAndTagging t = songAndTagDao.get(id);
		return t;
	}

}
