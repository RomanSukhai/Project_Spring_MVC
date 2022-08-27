package ua.lviv.lgs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Participant;

@Repository
public class ParticipantRepo {

	List<Participant> participants = new ArrayList<Participant>();

	
	public List<Participant> findAllBook() {
		return participants;
	}

	public Participant findById(Integer integer) {
		return participants.stream().filter(participant -> participant.getId() == integer).reduce((a, b) -> {
			throw new IllegalStateException("Multiple elements: " + a + ", " + b);
		}).get();
	}

	public void save(Participant participant) {
		Participant participantToUpdate = null;
		if (participant.getId() != null) {
			participantToUpdate = findById(participant.getId());
			if (participantToUpdate != null) {
				Participant participant2 = findById(participant.getId());
				int bookIndex = participants.indexOf(participant2);
				participantToUpdate.setName(participant2.getName());
				participantToUpdate.setEmail(participant2.getEmail());
				participantToUpdate.setPrimarySkill(participant2.getPrimarySkill());
				participantToUpdate.setLevel(participant.getLevel());
				participants.set(bookIndex, participantToUpdate);
			} else {
				participant.setId(participants.size());
				participants.add(participant);
			}
		}

	}

	public void delete(int id) {
		Iterator<Participant> iterator = participants.iterator();
		while (iterator.hasNext()) {
			Participant book = (Participant) iterator.next();
			if (book.getId().equals(id)) {
				iterator.remove();
			}
		}
	}

}
