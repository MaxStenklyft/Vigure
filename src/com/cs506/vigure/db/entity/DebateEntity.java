import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="debate_model")

public class DebateEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="topic")
	private String topic;
	
	@Column(name="status")
	private String status;
	
	@Column(name="instigatorNum")
	private long instigatorNum;
	
	@Column(name="defenderNum")
	private long defenderNum;
	
	@Column(name="startTime")
	private Date startTime;
	
	@Column(name="timeInterval")
	private int timeInterval;
}
