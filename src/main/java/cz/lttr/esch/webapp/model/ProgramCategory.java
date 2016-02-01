package cz.lttr.esch.webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "program_category", catalog = "esch")
public class ProgramCategory implements java.io.Serializable {

	private static final long serialVersionUID = -9012275715598872317L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", length = 30)
	@NotEmpty
	@Size(min = 2, max = 30, message = "Program category name must have between 2 and 30 characters")
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "programCategory")
	private Set<ProgramBlock> programBlocks = new HashSet<ProgramBlock>(0);

	public ProgramCategory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ProgramBlock> getProgramBlocks() {
		return this.programBlocks;
	}

	public void setProgramBlocks(Set<ProgramBlock> programBlocks) {
		this.programBlocks = programBlocks;
	}

}
