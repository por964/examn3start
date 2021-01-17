package dtos;

import entities.SportTeam;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claes
 */
public class SportTeamsDTO {
    
    List<SportTeamDTO> all = new ArrayList();

    public SportTeamsDTO(List<SportTeam> teams) {
        teams.forEach((p) -> {
            all.add(new SportTeamDTO(p));
        });
    }
    
    
    
}
