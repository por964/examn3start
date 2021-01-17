package dtos;

import entities.SportTeam;

/**
 *
 * @author claes
 */
public class SportTeamDTO {
    
    private String teamName;
    
    private String pricePerYear;
    private String minAge;
    private String maxAge;
    

    SportTeamDTO(SportTeam p) {
        this.teamName = p.getTeamName();
        this.pricePerYear = p.getPricePerYear();
        this.minAge = p.getMinAge();
        this.maxAge = p.getMaxAge();
        
    }
    
    
    
}
