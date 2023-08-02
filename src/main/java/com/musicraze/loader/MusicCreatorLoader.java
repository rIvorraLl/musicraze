package com.musicraze.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.musicraze.domain.MusicCreator;
import com.musicraze.repository.MusicCreatorRepository;

@Component

public class MusicCreatorLoader implements CommandLineRunner {

	private final MusicCreatorRepository repository;

	@Autowired

	public MusicCreatorLoader(MusicCreatorRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		this.repository.save(new MusicCreator("Wolves in the Throne Room"));
		this.repository.save(new MusicCreator("Lycia"));
		this.repository.save(new MusicCreator("Kate Bush"));
		this.repository.save(new MusicCreator("Talk Talk"));
		this.repository.save(new MusicCreator("Pantheist"));
		this.repository.save(new MusicCreator("Agalloch"));
		this.repository.save(new MusicCreator("Sisters of Mercy"));
		this.repository.save(new MusicCreator("The Cure"));
	}

}
