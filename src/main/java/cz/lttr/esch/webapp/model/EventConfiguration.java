package cz.lttr.esch.webapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "event_configuration", catalog = "esch")
public class EventConfiguration implements java.io.Serializable {

	private static final long serialVersionUID = -2515593269487750515L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id", nullable = false)
	private Event event;

	@Column(name = "base_time_interval", length = 20)
	@Enumerated(EnumType.STRING)
	private BaseTimeInterval baseTimeInterval;

	@Column(name = "layout", length = 20)
	@Enumerated(EnumType.STRING)
	@NotEmpty
	private EventLayout layout = EventLayout.HORIZONTAL;

	public EventConfiguration() {
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

	public BaseTimeInterval getBaseTimeInterval() {
		return this.baseTimeInterval;
	}

	public void setBaseTimeInterval(BaseTimeInterval baseTimeInterval) {
		this.baseTimeInterval = baseTimeInterval;
	}

	public EventLayout getLayout() {
		return this.layout;
	}

	public void setLayout(EventLayout layout) {
		this.layout = layout;
	}

}
