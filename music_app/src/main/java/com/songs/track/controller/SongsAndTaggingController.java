package com.songs.track.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.songs.track.model.Playlist;
import com.songs.track.model.PlaylistAddSongAndTagging;
import com.songs.track.model.Songs;
import com.songs.track.service.PlaylistAddingSongAndTaggingService;
import com.songs.track.service.PlaylistService;

@Controller
public class SongsAndTaggingController {

	@Autowired
	private PlaylistAddingSongAndTaggingService songAndTagServices;

	// add tags and songs to playlist
	@RequestMapping(value = "/playlist/addSongAndTag", method = RequestMethod.POST)
	public ResponseEntity<PlaylistAddSongAndTagging> addTagToPlaylist(
			@Valid @RequestBody PlaylistAddSongAndTagging songAndTag) {
		PlaylistAddSongAndTagging data = songAndTagServices.addSongAndTags(songAndTag);
		return new ResponseEntity<PlaylistAddSongAndTagging>(data, HttpStatus.OK);
	}

	// get playlistmapping entry by id
	@RequestMapping(value = "/playlist/playlistMapping/{id}", method = RequestMethod.GET)
	public ResponseEntity<PlaylistAddSongAndTagging> getAllPlaylist(@PathVariable("id") Long id) {

		PlaylistAddSongAndTagging p = songAndTagServices.getSongAndTaggingById(id);
		return new ResponseEntity<PlaylistAddSongAndTagging>(p, HttpStatus.OK);
	}

}
