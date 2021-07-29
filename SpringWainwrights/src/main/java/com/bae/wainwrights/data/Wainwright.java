package com.bae.wainwrights.data;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wainwright {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int ranking;
	private String name;
	private int elevation;
	private String region;

	public Wainwright(int ranking, String name, int elevation, String region) {
		super();
		this.ranking = ranking;
		this.name = name;
		this.elevation = elevation;
		this.region = region;

	}

	public Wainwright(int id, int ranking, String name, int elevation, String region) {
		super();
		this.id = id;
		this.ranking = ranking;
		this.name = name;
		this.elevation = elevation;
		this.region = region;
	}

	@Override
	public int hashCode() {
		return Objects.hash(elevation, id, name, ranking, region);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wainwright other = (Wainwright) obj;
		return Objects.equals(elevation, other.elevation) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(ranking, other.ranking) && region == other.region;
	}

	public Wainwright() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getElevation() {
		return elevation;
	}

	public void setElevation(int elevation) {
		this.elevation = elevation;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Wainwright [id=" + id + ", ranking=" + ranking + ", name=" + name + ", elevation=" + elevation
				+ ", region=" + region + "]";
	}

}
