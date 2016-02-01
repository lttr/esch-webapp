package cz.lttr.esch.webapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "program_block", catalog = "esch")
public class ProgramBlock implements java.io.Serializable {

	private static final long serialVersionUID = 3362562194147128535L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "program_category_id")
	private ProgramCategory programCategory;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "program_day_id")
	private ProgramDay programDay;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id")
	private Event event;

	@Column(name = "name", length = 30)
	@NotEmpty
	@Size(min = 2, max = 30, message = "Program block name must have between 2 and 30 characters")
	private String name;

	@Temporal(TemporalType.TIME)
	@Column(name = "start_time", length = 8)
	private Date startTime;

	@Temporal(TemporalType.TIME)
	@Column(name = "end_time", length = 8)
	private Date endTime;

	public ProgramBlock() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Instructor getInstructor() {
		return this.instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public ProgramCategory getProgramCategory() {
		return this.programCategory;
	}

	public void setProgramCategory(ProgramCategory programCategory) {
		this.programCategory = programCategory;
	}

	public ProgramDay getProgramDay() {
		return this.programDay;
	}

	public void setProgramDay(ProgramDay programDay) {
		this.programDay = programDay;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEventId(Event event) {
		this.event = event;
	}

}
