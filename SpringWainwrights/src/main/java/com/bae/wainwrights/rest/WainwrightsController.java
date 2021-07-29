package com.bae.wainwrights.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.wainwrights.data.Wainwright;
import com.bae.wainwrights.service.WainwrightService;

@RestController
@CrossOrigin

public class WainwrightsController {

	private WainwrightService service;

	public WainwrightsController(WainwrightService service) {

		super();
		this.service = service;
	}

	@PostMapping("/createWainwright")
	public ResponseEntity<Wainwright> createWainwright(@RequestBody Wainwright wainwright) {
		Wainwright created = this.service.createWainwright(wainwright);
		return new ResponseEntity<>(created, HttpStatus.CREATED);

	}

	@GetMapping("/getAllWainwrights")
	public List<Wainwright> getAllWainwrights() {
		return this.service.getAllWainwrights();
	}

	@GetMapping("/getByName/{name}")
	public List<Wainwright> getByName(@PathVariable String name) {
		return this.service.getByName(name);
	}

	@GetMapping("/getWainwright/{id}")
	public Wainwright getWainwright(@PathVariable int id) {
		return this.service.getWainwright(id);

	}

	@PutMapping("/replaceWainwright/{id}")
	public ResponseEntity<Wainwright> replaceWainwright(@PathVariable int id, @RequestBody Wainwright newWainwright) {
		Wainwright body = this.service.replaceWainwright(id, newWainwright);
		return new ResponseEntity<Wainwright>(body, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteWainwright/{id}")
	public ResponseEntity<String> deleteWainwright(@PathVariable int id) {
		String body = this.service.deleteWainwright(id);
		return new ResponseEntity<String>(body, HttpStatus.NO_CONTENT);
	}
}