package com.bae.wainwrights.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.bae.wainwrights.data.Wainwright;
import com.bae.wainwrights.data.repos.WainwrightRepo;

@Service
@Primary

public class WainwrightServiceDB implements WainwrightService {

	private WainwrightRepo repo;

	public WainwrightServiceDB(WainwrightRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Wainwright createWainwright(Wainwright wainwright) {
		return this.repo.save(wainwright);
	}

	@Override
	public List<Wainwright> getAllWainwrights() {
		return this.repo.findAll();
	}

	@Override
	public List<Wainwright> getByName(String name) {
		return this.repo.findByNameIgnoreCase(name);
	}

	@Override
	@Transactional
	public Wainwright getWainwright(int id) {
		Wainwright found = this.repo.findById(id).get();
		return found;

	}

	@Override
	public Wainwright replaceWainwright(int id, Wainwright newWainwright) {
		Wainwright found = this.repo.findById(id).get();

		System.out.println("FOUND: " + found);

		found.setElevation(newWainwright.getElevation());
		found.setName(newWainwright.getName());
		found.setRanking(newWainwright.getRanking());
		found.setRegion(newWainwright.getRegion());

		System.out.println("FOUND AFTER UPDATE:" + found);

		Wainwright updated = this.repo.save(found);
		System.out.println("UPDATED:" + updated);
		return updated;
	}

	@Override
	public String deleteWainwright(int id) {
		this.repo.deleteById(id);

		if (this.repo.existsById(id)) {
			return "Not deleted: " + id;
		} else {

			return "Deleted: " + id;
		}
	}
}