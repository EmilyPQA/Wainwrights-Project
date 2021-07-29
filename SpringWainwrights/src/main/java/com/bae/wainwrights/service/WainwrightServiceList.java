package com.bae.wainwrights.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.wainwrights.data.Wainwright;

@Service

public class WainwrightServiceList implements WainwrightService {

	private List<Wainwright> wainwrights = new ArrayList<>();

	@Override
	public Wainwright createWainwright(Wainwright wainwright) {
		System.out.println(wainwright);
		this.wainwrights.add(wainwright);
		return this.wainwrights.get(this.wainwrights.size() - 1);

	}

	@Override
	public List<Wainwright> getAllWainwrights() {
		return this.wainwrights;
	}

	@Override
	public Wainwright getWainwright(int id) {
		Wainwright found = this.wainwrights.get(id);
		return found;
	}

	@Override
	public Wainwright replaceWainwright(int id, Wainwright newWainwright) {
		return this.wainwrights.set(id, newWainwright);
	}

	@Override
	public String deleteWainwright(int id) {
		this.wainwrights.remove(id);

		return "Deleted car at index: " + id;
	}

	@Override
	public List<Wainwright> getByName(String name) {
		return null;
	}
}
