package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author claes
 */
@Entity
public class MemberInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private boolean payed;
    
    //@Column(name = "date_paid", columnDefinition = "DATE")
    //private LocalDate localDate;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePaid;
    
    @ManyToOne
    private Player player;
    
    @ManyToOne
    private SportTeam team;
    
    

    public MemberInfo() {
        datePaid = new Date();
    }

    public MemberInfo(Date datePaid) {
        this.datePaid = new Date();
    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public Date getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Date datePaid) {
        this.datePaid = datePaid;
    }

    

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public SportTeam getTeam() {
        return team;
    }

    public void setTeam(SportTeam team) {
        this.team = team;
    }
    
    
    
    
    

}