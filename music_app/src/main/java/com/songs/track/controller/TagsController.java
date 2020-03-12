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
import org.springframework.web.bind.annotation.RequestParam;

import com.songs.track.model.Playlist;
import com.songs.track.model.Songs;
import com.songs.track.model.Tags;
import com.songs.track.model.UserDetails;
import com.songs.track.service.TagsService;

@Controller
public class TagsController {

	@Autowired
	private TagsService tagService;

	// get all tag
	@RequestMapping(value = "/tag", method = RequestMethod.GET)
	public ResponseEntity<List<Tags>> getAllTags() {

		List<Tags> taglist = tagService.getAllTags();
		return new ResponseEntity<List<Tags>>(taglist, HttpStatus.OK);
	}

	// get tag by id
	@RequestMapping(value = "/tag/{id}", method = RequestMethod.GET)
	public ResponseEntity<Tags> getTagsById(@PathVariable("id") Long id) {
		Tags tag = tagService.getTagById(id);
		return new ResponseEntity<Tags>(tag, HttpStatus.OK);
	}

	// create tag
	@RequestMapping(value = "/tag", method = RequestMethod.POST)
	public ResponseEntity<Tags> createTag(@Valid @RequestBody Tags tag) {
		Tags data = tagService.createTag(tag);
		return new ResponseEntity<Tags>(data, HttpStatus.OK);
	}

	// explore tags to get playlist
	@RequestMapping(value = "/tag/explorePlaylist",params="tagsIds", method = RequestMethod.GET)
	public ResponseEntity<List<Playlist>> getPlaylistFromTag(@RequestParam("tagsIds") List<Integer> ids) {
		List<Playlist> p = tagService.exploreTagedPlaylist(ids);
		return new ResponseEntity<List<Playlist>>(p, HttpStatus.OK);
	}

}
