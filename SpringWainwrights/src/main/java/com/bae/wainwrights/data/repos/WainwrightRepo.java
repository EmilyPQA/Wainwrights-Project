package com.bae.wainwrights.data.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.wainwrights.data.Wainwright;

@Repository

public interface WainwrightRepo extends JpaRepository<Wainwright, Integer> {

	List<Wainwright> findByNameIgnoreCase(String name);

}