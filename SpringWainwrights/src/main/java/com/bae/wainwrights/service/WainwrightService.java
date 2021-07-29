package com.bae.wainwrights.service;

import java.util.List;

import com.bae.wainwrights.data.Wainwright;

public interface WainwrightService {

	public Wainwright createWainwright(Wainwright wainwright);

	public List<Wainwright> getAllWainwrights();

	public Wainwright getWainwright(int id);

	public Wainwright replaceWainwright(int id, Wainwright newWainwright);

	public String deleteWainwright(int id);

	List<Wainwright> getByName(String name);

}
