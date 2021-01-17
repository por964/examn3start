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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author claes
 */
@Entity
@NamedQuery(name = "Sport.deleteAllRows", query = "DELETE from Sport")
public class Sport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String name;
    
    private String description;
    
    @OneToMany(mappedBy = "sport", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    List<SportTeam> teams = new ArrayList<>();

    public Sport() {
    }

    public Sport(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    
    
    public void addSportTeam(SportTeam st) {
        this.teams.add(st);
        if (st != null) {
            st.setSport(this);
        }
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<SportTeam> getTeams() {
        return teams;
    }

    public void setTeams(List<SportTeam> teams) {
        this.teams = teams;
    }
    
    




    
}
