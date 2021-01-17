package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author claes
 */
@Entity
@NamedQuery(name = "SportTeam.getAllRows", query = "SELECT s from SportTeam s")
@NamedQuery(name = "SportTeam.deleteAllRows", query = "DELETE from SportTeam")
public class SportTeam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String teamName;
    
    private String pricePerYear;
    private String minAge;
    private String maxAge;
    
    @ManyToOne
    private Sport sport;
    
    @OneToMany(mappedBy = "team", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    List<MemberInfo> infos;
    
    @ManyToOne
    private Coach coach;

    public SportTeam() {
        this.infos = new ArrayList();
    }

    public SportTeam(String teamName, String pricePerYear, String minAge, String maxAge) {
        this.teamName = teamName;
        this.pricePerYear = pricePerYear;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.infos = new ArrayList();
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
    
    

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPricePerYear() {
        return pricePerYear;
    }

    public void setPricePerYear(String pricePerYear) {
        this.pricePerYear = pricePerYear;
    }

    public String getMinAge() {
        return minAge;
    }

    public void setMinAge(String minAge) {
        this.minAge = minAge;
    }

    public String getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public List<MemberInfo> getInfos() {
        return infos;
    }

    public void setInfos(List<MemberInfo> infos) {
        this.infos = infos;
    }
    
    
    public void addMemberInfo(MemberInfo mi) {
        this.infos.add(mi);
        if (mi != null) {
            mi.setTeam(this);
        }
    }


    
    
    
    
    

    
    
    
}
