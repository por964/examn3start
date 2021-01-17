package dtos;

import entities.Sport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claes
 */
public class SportsDTO {
    
    List<SportDTO> all = new ArrayList();

    public SportsDTO() {
    }
    
    public SportsDTO(List<Sport> sportEntities) {
        sportEntities.forEach((s) -> {
            all.add(new SportDTO(s));
        });
    }

    public List<SportDTO> getAll() {
        return all;
    }

    public void setAll(List<SportDTO> all) {
        this.all = all;
    }
    

    
}
