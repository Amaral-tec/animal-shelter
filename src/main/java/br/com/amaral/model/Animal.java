package br.com.amaral.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.amaral.enums.Species;

@Entity
@Table(name = "animals")
@SequenceGenerator(name = "seq_animal", sequenceName = "seq_animal", allocationSize = 1, initialValue = 1)
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_animal")
	private Long id;
	
	@Column(nullable=false)
	private Species species;

	@Column(name= "provisional_name", nullable=false)
	private String provisionalName;
	
	@Column(name= "estimated_age", nullable=false)
	private String estimatedAge;
	
	@Column(nullable=false)
	private String breed;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date arrival;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date adoption;
	
	@Column(name= "arrival_conditions", nullable=false)
	private String arrivalConditions;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_death")
	private Date dateDeath;
	
	@Column(name= "received_by", nullable=false)
	private String receivedBy;
	
	@Column(name= "is_male", nullable=false)
	private boolean isMale;
	
	@Column(name= "is_spayed_or_neutered", nullable=false)
    private boolean isSpayedOrNeutered;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public String getProvisionalName() {
		return provisionalName;
	}

	public void setProvisionalName(String provisionalName) {
		this.provisionalName = provisionalName;
	}

	public String getEstimatedAge() {
		return estimatedAge;
	}

	public void setEstimatedAge(String estimatedAge) {
		this.estimatedAge = estimatedAge;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public Date getAdoption() {
		return adoption;
	}

	public void setAdoption(Date adoption) {
		this.adoption = adoption;
	}

	public String getArrivalConditions() {
		return arrivalConditions;
	}

	public void setArrivalConditions(String arrivalConditions) {
		this.arrivalConditions = arrivalConditions;
	}

	public Date getDateDeath() {
		return dateDeath;
	}

	public void setDateDeath(Date dateDeath) {
		this.dateDeath = dateDeath;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public boolean isSpayedOrNeutered() {
		return isSpayedOrNeutered;
	}

	public void setSpayedOrNeutered(boolean isSpayedOrNeutered) {
		this.isSpayedOrNeutered = isSpayedOrNeutered;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(id, other.id);
	}
	
}

