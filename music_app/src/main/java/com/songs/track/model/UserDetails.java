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
@Table(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;

	@Column
	private String user_name;

	@Column
	private String email;
	
	@OneToMany(targetEntity = Playlist.class, mappedBy = "user_id", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Playlist> playlist;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long id) {
		this.user_id = id;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	


}
