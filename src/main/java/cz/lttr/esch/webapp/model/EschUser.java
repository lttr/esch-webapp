package cz.lttr.esch.webapp.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "esch_user", catalog = "esch", uniqueConstraints = {
	@UniqueConstraint(columnNames = "email"), @UniqueConstraint(columnNames = "login") })
public class EschUser implements Serializable {

    private static final long serialVersionUID = 5958894701034851018L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "login", unique = true, nullable = false, length = 50)
    @NotEmpty
    @Size(min = 3, max = 50, message = "Login name must contain between 3 and 50 characters")
    private String login;

    @Column(name = "password", length = 50)
    @NotEmpty
    @Size(min = 3, max = 50, message = "Password must contain between 3 and 50 characters")
    private String password;

    @Column(name = "first_name", length = 50)
    @Size(min = 3, max = 50, message = "First name must contain between 3 and 50 characters")
    private String firstName;

    @Column(name = "last_name", length = 50)
    @Size(min = 3, max = 50, message = "Last name must contain between 3 and 50 characters")
    private String lastName;

    @Column(name = "email", unique = true, nullable = false, length = 50)
    @NotEmpty
    @Email(message = "You have insert valid email address")
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date", length = 19)
    @NotEmpty
    private Date registrationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastactivity_date", length = 19)
    @NotEmpty
    private Date lastactivityDate;

    @Column(name = "locked")
    @NotEmpty
    private boolean locked = false;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eschUser")
    private Set<Event> events = new HashSet<Event>(0);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public EschUser() {
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

    public String getLogin() {
	return this.login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	this.password = password;
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

    public String getEmail() {
	return this.email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Date getRegistrationDate() {
	return this.registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
	this.registrationDate = registrationDate;
    }

    public Date getLastactivityDate() {
	return this.lastactivityDate;
    }

    public void setLastactivityDate(Date lastactivityDate) {
	this.lastactivityDate = lastactivityDate;
    }

    public boolean getLocked() {
	return this.locked;
    }

    public void setLocked(boolean locked) {
	this.locked = locked;
    }

    public Set<Event> getEvents() {
	return this.events;
    }

    public void setEvents(Set<Event> events) {
	this.events = events;
    }

}
