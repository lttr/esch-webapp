package cz.lttr.esch.webapp.model;
// Generated 1.2.2016 7:18:36 by Hibernate Tools 4.3.1.Final


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Instructor generated by hbm2java
 */
@Entity
@Table(name="instructor"
    ,catalog="esch"
)
public class Instructor  implements java.io.Serializable {


     private int id;
     private String firstName;
     private String lastName;
     private String nickname;
     private Set<Event> events = new HashSet<Event>(0);
     private Set<ProgramBlock> programBlocks = new HashSet<ProgramBlock>(0);
     private Set<EschUser> eschUsers = new HashSet<EschUser>(0);

    public Instructor() {
    }

	
    public Instructor(int id) {
        this.id = id;
    }
    public Instructor(int id, String firstName, String lastName, String nickname, Set<Event> events, Set<ProgramBlock> programBlocks, Set<EschUser> eschUsers) {
       this.id = id;
       this.firstName = firstName;
       this.lastName = lastName;
       this.nickname = nickname;
       this.events = events;
       this.programBlocks = programBlocks;
       this.eschUsers = eschUsers;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="first_name", length=30)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="last_name", length=30)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="nickname", length=30)
    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="event_instructors", catalog="esch", joinColumns = { 
        @JoinColumn(name="instructor_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="event_id", nullable=false, updatable=false) })
    public Set<Event> getEvents() {
        return this.events;
    }
    
    public void setEvents(Set<Event> events) {
        this.events = events;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="instructor")
    public Set<ProgramBlock> getProgramBlocks() {
        return this.programBlocks;
    }
    
    public void setProgramBlocks(Set<ProgramBlock> programBlocks) {
        this.programBlocks = programBlocks;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="instructor")
    public Set<EschUser> getEschUsers() {
        return this.eschUsers;
    }
    
    public void setEschUsers(Set<EschUser> eschUsers) {
        this.eschUsers = eschUsers;
    }




}


