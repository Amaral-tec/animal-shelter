package br.com.amaral.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.amaral.model.Animal;

@Transactional
public interface IAnimalRepository extends JpaRepository<Animal, Long> {

	@Query("SELECT a FROM a WHERE a.adoption IS NULL ORDER BY a.arrival")
	List<Animal> findNotAdopted();
	
	@Query("SELECT a FROM a WHERE a.adoption IS NOT NULL")
	List<Animal> findAdopted();
	
	@Query("SELECT a FROM a WHERE a.arrivalDate BETWEEN :startDate AND :endDate")
    List<Animal> findAllByArrivalDateBetween(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
	
}
