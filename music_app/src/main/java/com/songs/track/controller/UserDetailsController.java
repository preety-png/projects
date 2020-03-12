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
import com.songs.track.model.UserDetails;
import com.songs.track.service.UserDetailsService;

@Controller
public class UserDetailsController {

	@Autowired
	private UserDetailsService userDetailsService;

	// get all users
	@RequestMapping(value = "/userDetails/user", method = RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> getUserDetails() {

		List<UserDetails> userlist = userDetailsService.getUserDetails();
		return new ResponseEntity<List<UserDetails>>(userlist, HttpStatus.OK);
	}

	// get users by id
	@RequestMapping(value = "/userDetails/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDetails> getUserDetailsById(@PathVariable("id") Long id) {

		UserDetails userDetails = userDetailsService.getUserDetailsById(id);
		return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
	}

	// delete user
	@RequestMapping(value = "/userDetails/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteUserDetailsById(@PathVariable("id") Long id) {

		boolean result = userDetailsService.deleteUserDetailsById(id);
		return new ResponseEntity(result, HttpStatus.OK);
	}

	// create user
	@RequestMapping(value = "/userDetails/user", method = RequestMethod.POST)
	public ResponseEntity<UserDetails> createUserDetails(@Valid @RequestBody UserDetails user) {
		UserDetails data = userDetailsService.createUserDetails(user);
		return new ResponseEntity<UserDetails>(data, HttpStatus.OK);
	}

	// get playlist
	@RequestMapping(value = "/userDetails/playlist/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Playlist>> getUserPlaylist(@PathVariable("id") Long id) {
		List<Playlist> data = userDetailsService.getUserPlayList(id);
		return new ResponseEntity<List<Playlist>>(data, HttpStatus.OK);
	}

}
