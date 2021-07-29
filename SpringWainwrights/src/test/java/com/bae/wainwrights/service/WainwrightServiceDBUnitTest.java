package com.bae.wainwrights.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.bae.wainwrights.data.Wainwright;
import com.bae.wainwrights.data.repos.WainwrightRepo;

@SpringBootTest
@ActiveProfiles("test")

public class WainwrightServiceDBUnitTest {

	@Autowired
	private WainwrightServiceDB service;

	@MockBean
	private WainwrightRepo repo;

	@Test
	void testCreate() {

		Wainwright newWainwright = new Wainwright(14, "Blencathra", 868, "Northern");

		Wainwright savedWainwright = new Wainwright(1, 14, "Blencathra", 868, "Northern");

		Mockito.when(this.repo.save(newWainwright)).thenReturn(savedWainwright);

		assertThat(this.service.createWainwright(newWainwright)).isEqualTo(savedWainwright);

		Mockito.verify(this.repo, Mockito.times(1)).save(newWainwright);
	}

	@Test
	void testGetAll() {
		List<Wainwright> testWainwrights = List.of(new Wainwright(1, 14, "Blencathra", 868, "Northern"));

		Mockito.when(this.repo.findAll()).thenReturn(testWainwrights);

		assertThat(this.service.getAllWainwrights()).isEqualTo(testWainwrights);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	void testGetAllByName() {

		List<Wainwright> testWainwrights = List.of(new Wainwright(1, 14, "Blencathra", 868, "Northern"));

		String search = "Blencathra";
		Mockito.when(this.repo.findByNameIgnoreCase(search)).thenReturn(testWainwrights);

		assertThat(this.service.getByName(search)).isEqualTo(testWainwrights);

		Mockito.verify(this.repo, Mockito.times(1)).findByNameIgnoreCase(search);
	}

	@Test
	void testUpdate() {
		int id = 1;

		Wainwright testWainwright = new Wainwright(id, 214, "Castle Crag", 300, "North Western");
		Wainwright testNewWainwright = new Wainwright(id, 1, "Scafell Pike", 978, "Southern");

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(testWainwright));
		Mockito.when(this.repo.save(new Wainwright(id, 1, "Scafell Pike", 978, "Southern")))
				.thenReturn(testNewWainwright);

		Wainwright actual = this.service.replaceWainwright(id, testNewWainwright);

		assertThat(actual).isEqualTo(testNewWainwright);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(new Wainwright(id, 1, "Scafell Pike", 978, "Southern"));

	}

	@Test
	void testDeleteSucceeds() {
		int id = 1;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertThat(this.service.deleteWainwright(id)).isEqualTo("Deleted: " + id);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}

	@Test
	void testDeleteFails() {
		int id = 1;

		Mockito.when(this.repo.existsById(id)).thenReturn(true);

		assertThat(this.service.deleteWainwright(id)).isEqualTo("Not deleted: " + id);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}
}