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
import com.songs.track.model.Songs;
import com.songs.track.service.PlaylistService;

@Controller
public class PlaylistController {
	@Autowired
	private PlaylistService playlistService;

	// get all playlist
	@RequestMapping(value = "/playlist", method = RequestMethod.GET)
	public ResponseEntity<List<Playlist>> getAllPlaylist() {

		List<Playlist> playlist = playlistService.getAllPlaylist();
		return new ResponseEntity<List<Playlist>>(playlist, HttpStatus.OK);
	}

	// get playlist by id
	@RequestMapping(value = "/playlist/{id}", method = RequestMethod.GET)
	public ResponseEntity<Playlist> getPlaylistById(@PathVariable("id") Long id) {

		Playlist playlist = playlistService.getPlaylistById(id);
		return new ResponseEntity<Playlist>(playlist, HttpStatus.OK);
	}

	// delete playlist
	@RequestMapping(value = "/playlist/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deletePlaylistById(@PathVariable("id") Long id) {

		boolean result = playlistService.deletePlaylistById(id);
		return new ResponseEntity(result, HttpStatus.OK);
	}

	// create playlist
	@RequestMapping(value = "/playlist", method = RequestMethod.POST)
	public ResponseEntity<Playlist> createPlaylist(@Valid @RequestBody Playlist playlist) {
		Playlist data = playlistService.createPlaylist(playlist);
		return new ResponseEntity<Playlist>(data, HttpStatus.OK);
	}

	// get songs from from playlist
	@RequestMapping(value = "/playlist/exploreSongs/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Songs>> getSongFromPlaylist(@PathVariable("id") Long id) {
		List<Songs> s = playlistService.explorePlaylistSongs(id);
		return new ResponseEntity<List<Songs>>(s, HttpStatus.OK);
	}

}
