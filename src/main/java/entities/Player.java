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
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String email;
    private String phone;
    private String age;
    
    @OneToMany(mappedBy = "player", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    List<MemberInfo> info = new ArrayList<>();

    public Player() {
    }

    public Player(String name, String email, String phone, String age) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<MemberInfo> getInfo() {
        return info;
    }

    public void setInfo(List<MemberInfo> info) {
        this.info = info;
    }
    
    public void addMemberInfo(MemberInfo mi) {
        this.info.add(mi);
        if (mi != null) {
            mi.setPlayer(this);
        }
    
    
      

    }
    
}
