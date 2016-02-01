package cz.lttr.esch.webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "program_day", catalog = "esch")
public class ProgramDay implements java.io.Serializable {

	private static final long serialVersionUID = -391607088775680331L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id", nullable = false)
	private Event event;

	@Column(name = "ordinal_number", nullable = false)
	private int ordinalNumber;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "programDay")
	private Set<ProgramBlock> programBlocks = new HashSet<ProgramBlock>(0);

	public ProgramDay() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public int getOrdinalNumber() {
		return this.ordinalNumber;
	}

	public void setOrdinalNumber(int ordinalNumber) {
		this.ordinalNumber = ordinalNumber;
	}

	public Set<ProgramBlock> getProgramBlocks() {
		return this.programBlocks;
	}

	public void setProgramBlocks(Set<ProgramBlock> programBlocks) {
		this.programBlocks = programBlocks;
	}

}
