package br.com.amaral.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.amaral.model.Animal;
import br.com.amaral.repository.IAnimalRepository;
import br.com.amaral.service.AnimalService;

@RestController
@RequestMapping("/animals")
public class AnimalController {

	@Autowired
	private IAnimalRepository animalRepository;
	
	@Autowired
	private AnimalService animalService;

	@ResponseBody
	@PostMapping(value = "/create")
	public ResponseEntity<Animal> create(@RequestBody Animal animal) {

		animal = animalRepository.save(animal);

		return new ResponseEntity<>(animal, HttpStatus.OK);
	}

	@ResponseBody
	@PostMapping(value = "/delete")
	public ResponseEntity<String> delete(@RequestBody Animal animal) {

		animalRepository.deleteById(animal.getId());

		return new ResponseEntity<>("OK: Deletion completed successfully.", HttpStatus.OK);
	}

	@ResponseBody
	@DeleteMapping(value = "/delete-by-id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {

		animalRepository.findById(id).orElse(null);

		animalRepository.deleteById(id);

		return new ResponseEntity<>("OK: Deletion completed successfully.", HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping(value = "/find-by-id/{id}")
	public ResponseEntity<Animal> findById(@PathVariable("id") Long id) {

		animalRepository.findById(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ResponseBody
	@GetMapping(value = "/find-all")
	public ResponseEntity<Animal> findAll() {

		animalRepository.findAll();

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping(value = "/not-adopted")
	public ResponseEntity<List<Animal>> findNotAdopted() {

		animalRepository.findNotAdopted();

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ResponseBody
	@GetMapping(value = "/find-adopted")
	public ResponseEntity<List<Animal>> findAdopted() {

		animalRepository.findAdopted();

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping("/rescued-by-recipients")
    public Map<String, Long> countAnimalsRescuedByRecipientInDateRange(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        return animalService.countAnimalsRescuedByRecipientInDateRange(start, end);
    }
}
