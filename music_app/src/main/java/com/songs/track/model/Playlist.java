package com.songs.track.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "PLAYLIST")
public class Playlist   {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long playlist_id;
	
	@Column
	private String playlist_name;

	@Column
	private long user_id;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private UserDetails user;
	
	@OneToMany(targetEntity = PlaylistAddSongAndTagging.class, mappedBy = "playlist_id", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<PlaylistAddSongAndTagging> songsAndTagging;
	
	public Long getPlaylist_id() {
		return playlist_id;
	}
	
	public void setPlaylist_id(long playlist_id) {
		this.playlist_id = playlist_id;
	}

	
	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	

	public String getPlaylist_name() {
		return playlist_name;
	}

	public void setPlaylist_Name(String playlist_name) {
		this.playlist_name = playlist_name;
	}
	
}
