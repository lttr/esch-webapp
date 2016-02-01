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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "instructor", catalog = "esch")
public class Instructor implements java.io.Serializable {

	private static final long serialVersionUID = -1327998230096868636L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name", length = 50)
	@Size(min = 3, max = 50, message = "First name must contain between 3 and 50 characters")
	private String firstName;

	@Column(name = "last_name", length = 50)
	@Size(min = 3, max = 50, message = "Last name must contain between 3 and 50 characters")
	private String lastName;

	@Column(name = "nickname", length = 50, unique = true)
	@Size(min = 2, max = 50, message = "Last name must contain between 3 and 50 characters")
	@NotEmpty
	private String nickname;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "event_instructors", catalog = "esch", joinColumns = {
			@JoinColumn(name = "instructor_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "event_id", nullable = false, updatable = false) })
	private Set<Event> events = new HashSet<Event>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor")
	private Set<ProgramBlock> programBlocks = new HashSet<ProgramBlock>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor")
	private Set<EschUser> eschUsers = new HashSet<EschUser>(0);

	public Instructor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Set<Event> getEvents() {
		return this.events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public Set<ProgramBlock> getProgramBlocks() {
		return this.programBlocks;
	}

	public void setProgramBlocks(Set<ProgramBlock> programBlocks) {
		this.programBlocks = programBlocks;
	}

	public Set<EschUser> getEschUsers() {
		return this.eschUsers;
	}

	public void setEschUsers(Set<EschUser> eschUsers) {
		this.eschUsers = eschUsers;
	}

}
