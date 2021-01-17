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
import javax.persistence.OneToMany;

/**
 *
 * @author claes
 */
@Entity
public class Coach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "coach", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    List<SportTeam> teams = new ArrayList<>();

    public Coach() {
    }

    public Coach(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<SportTeam> getTeams() {
        return teams;
    }

    public void setTeams(List<SportTeam> teams) {
        this.teams = teams;
    }

    public void addSportTeam(SportTeam st) {
        this.teams.add(st);
        if (st != null) {
            st.setCoach(this);
        }

    }
}
