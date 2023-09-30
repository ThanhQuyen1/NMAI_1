package task2;

import java.util.Random;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		String[] actions = {"MOVE_UP", "MOVE_RIGHT", "MOVE_DOWN", "MOVE_LEFT"};
		Random rd = new Random();
		int random = rd.nextInt(actions.length-1);
		if (p.getLocationState() == p.getLocationState().DIRTY) {
			return Environment.SUCK_DIRT;
		} else if(p.getAgentLocation() == Environment.LOCATION_A) {
			if (random == 1) {
				return Environment.MOVE_RIGHT ;				
			}else if (random == 2) {
				return Environment.MOVE_DOWN;
			}else {
				return null;
			}
		}else if(p.getAgentLocation() == Environment.LOCATION_B) {
			if (random == 3) {
				return Environment.MOVE_LEFT ;				
			}else if (random == 2) {
				return Environment.MOVE_DOWN;
			}else {
				return null;
			}
		}else if(p.getAgentLocation() == Environment.LOCATION_C) {
			if (random == 3) {
				return Environment.MOVE_LEFT ;				
			}else if (random == 0) {
				return Environment.MOVE_UP;
			}else {
				return null;
			}
		}else if(p.getAgentLocation() == Environment.LOCATION_D) {
			if (random == 1) {
				return Environment.MOVE_RIGHT ;				
			}else if (random == 0) {
				return Environment.MOVE_UP;
			}else {
				return null;
			}
		}
		return null;
		
	}
}