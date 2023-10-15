package br.com.amaral.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amaral.model.Animal;
import br.com.amaral.repository.IAnimalRepository;

@Service
public class AnimalService {
	
	@Autowired
	private IAnimalRepository animalRepository;

	public Map<String, Long> countAnimalsRescuedByRecipientInDateRange(LocalDate startDate, LocalDate endDate) {
        List<Animal> animals = animalRepository.findAllByArrivalDateBetween(startDate, endDate);

        Map<String, Long> recipientCountMap = new HashMap<>();

        for (Animal animal : animals) {
            String receivedBy = animal.getReceivedBy();
            recipientCountMap.put(receivedBy, recipientCountMap.getOrDefault(receivedBy, 0L) + 1);
        }

        return recipientCountMap;
    }
}
