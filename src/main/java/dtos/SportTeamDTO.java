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
    

    public SportTeamDTO(SportTeam p) {
        this.teamName = p.getTeamName();
        this.pricePerYear = p.getPricePerYear();
        this.minAge = p.getMinAge();
        this.maxAge = p.getMaxAge();
        
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
    
    
    
    
}
