package com.songs.track.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SONGS")
public class Songs {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int song_id;
	
	@Column
	String songs_name;
	
	@Column
	String songs_artist;
	
	@Column
	String songs_language;
		

	@OneToMany(targetEntity = Songs.class, mappedBy = "song_id", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<PlaylistAddSongAndTagging> songsAndTagging;

	
	public int getSong_id() {
		return song_id;
	}

	public void setSong_id(int song_id) {
		this.song_id = song_id;
	}

	public String getSongs_name() {
		return songs_name;
	}

	public void setSongs_name(String songs_name) {
		this.songs_name = songs_name;
	}

	public String getSongs_artist() {
		return songs_artist;
	}

	public void setSongs_artist(String songs_artist) {
		this.songs_artist = songs_artist;
	}

	public String getSongs_language() {
		return songs_language;
	}

	public void setSongs_language(String songs_language) {
		this.songs_language = songs_language;
	}




}
