
package dtos;

import entities.Sport;

/**
 *
 * @author claes
 */
public class SportDTO {
    
    private String name;
    private String description;

    public SportDTO(Sport sport) {
        this.name = sport.getName();
        this.description = sport.getDescription();
        
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
    
    
    
    
    
}
