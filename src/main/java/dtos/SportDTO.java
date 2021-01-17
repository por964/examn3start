
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
    
    
    
}
