package com.songs.track.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name ="TAGGING_AND_ADDSONG")
public class PlaylistAddSongAndTagging {
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long playlistmapping_id;
		
	@Column
	private long  playlist_id;
	

	@Column
	private long  song_id;
	
	@Column
	private long  tag_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "playlist_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Playlist playlist;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "song_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Songs song;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tag_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Tags tag;
	
	
	
	public long getPlaylistmapping_id() {
		return playlistmapping_id;
	}
	public void setPlaylistMapping_id(long playlistMapping_id) {
		this.playlistmapping_id = playlistMapping_id;
	}
	public long getPlaylist_id() {
		return playlist_id;
	}
	public void setPlaylist_id(long playlist_id) {
		this.playlist_id = playlist_id;
	}
	public long getSong_id() {
		return song_id;
	}
	public void setSong_id(long song_id) {
		this.song_id = song_id;
	}
	public long getTag_id() {
		return tag_id;
	}
	public void setTag_id(long tag_id) {
		this.tag_id = tag_id;
	}
	

}
