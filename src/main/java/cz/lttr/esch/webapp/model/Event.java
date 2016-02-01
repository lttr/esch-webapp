package cz.lttr.esch.webapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "event", catalog = "esch", uniqueConstraints = @UniqueConstraint(columnNames = "name") )
public class Event implements Serializable {

	private static final long serialVersionUID = 6913256377004797096L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "esch_user_id")
	private EschUser eschUser;

	@Column(name = "name", unique = true, length = 40)
	@Size(min = 3, max = 40, message = "Event name must have between 3 and 40 characters")
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", length = 10)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", length = 10)
	private Date endDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, length = 19)
	@NotEmpty
	private Date created;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "event", cascade = CascadeType.ALL)
	private Set<EventConfiguration> eventConfigurations = new HashSet<EventConfiguration>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "event", cascade = CascadeType.ALL)
	private Set<ProgramDay> programDays = new HashSet<ProgramDay>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "event", cascade = CascadeType.ALL)
	private Set<ProgramBlock> programBlocks = new HashSet<ProgramBlock>(0);

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "event_instructors", catalog = "esch", joinColumns = {
			@JoinColumn(name = "event_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "instructor_id", nullable = false, updatable = false) })
	private Set<Instructor> instructors = new HashSet<Instructor>(0);

	public Event() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EschUser getEschUser() {
		return this.eschUser;
	}

	public void setEschUser(EschUser eschUser) {
		this.eschUser = eschUser;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Set<EventConfiguration> getEventConfigurations() {
		return this.eventConfigurations;
	}

	public void setEventConfigurations(Set<EventConfiguration> eventConfigurations) {
		this.eventConfigurations = eventConfigurations;
	}

	public Set<Instructor> getInstructors() {
		return this.instructors;
	}

	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
	}

	public Set<ProgramDay> getProgramDays() {
		return this.programDays;
	}

	public void setProgramDays(Set<ProgramDay> programDays) {
		this.programDays = programDays;
	}

}
