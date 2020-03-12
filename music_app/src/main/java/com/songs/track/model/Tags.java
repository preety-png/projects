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
@Table(name = "TAGS")
public class Tags {

	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tag_id;

	@Column
	private String tag_name;

	@OneToMany(targetEntity = PlaylistAddSongAndTagging.class, mappedBy = "tag_id", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<PlaylistAddSongAndTagging> songsAndTagging;


	public long getTag_id() {
		return tag_id;
	}

	public void setTag_id(long tag_id) {
		this.tag_id = tag_id;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}

	
	

}
