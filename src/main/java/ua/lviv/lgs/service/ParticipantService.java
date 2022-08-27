package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.ParticipantRepo;
import ua.lviv.lgs.domain.Participant;

@Service
public class ParticipantService {

	@Autowired
	public ParticipantRepo bookRepo = new ParticipantRepo() ;

	
	public Participant findById(Integer integer) {
		return bookRepo.findById(integer);
	}
	
	public List<Participant> findAllParticipant() {
		return bookRepo.findAllBook();
	}
	public void delete(int id) {
		bookRepo.delete(id);
	}

	public void save(Participant book) {
		bookRepo.save(book);
	}
}
