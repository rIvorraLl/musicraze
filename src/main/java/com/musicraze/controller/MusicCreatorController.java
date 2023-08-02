package com.musicraze.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicraze.domain.MusicCreator;
import com.musicraze.repository.MusicCreatorRepository;

@CrossOrigin
@RestController
@RequestMapping("api/musiccreators")
public class MusicCreatorController {
	private final MusicCreatorRepository mcRepository;
	
	public MusicCreatorController(MusicCreatorRepository mcRepository) {
		this.mcRepository = mcRepository;
	}
	
	@GetMapping
	public List<MusicCreator> getMusicCreators() {
		return mcRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public MusicCreator getMusicCreator(@PathVariable Long id) {
		return mcRepository.findById(id).orElseThrow(RuntimeException::new);
	}
	
	@PostMapping
	public ResponseEntity<MusicCreator> createMusicCreator(@RequestBody MusicCreator mc) throws URISyntaxException {
		MusicCreator savedMusicCreator = mcRepository.save(mc);
		return ResponseEntity.created(new URI("/api/musiccreators" + savedMusicCreator.getId())).body(savedMusicCreator);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MusicCreator> updateMusicCreator(@PathVariable Long id, @RequestBody MusicCreator mc) {
		MusicCreator currentMusicCreator = mcRepository.findById(id).orElseThrow(RuntimeException::new);
		currentMusicCreator.setName(mc.getName());
		currentMusicCreator = mcRepository.save(mc);
		return ResponseEntity.ok(currentMusicCreator);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMusicCreator(@PathVariable Long id) {
		mcRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
