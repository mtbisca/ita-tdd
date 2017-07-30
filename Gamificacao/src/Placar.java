import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;


public class Placar {
	ArmazenamentoGenerico arm;
	
	public Placar(ArmazenamentoGenerico arm) {
		this.arm = arm;
	}
	
	public void registraPontos(String usuario, int numeroDePontos, String tipoDePonto) {
		arm.armazenaPontos(usuario, numeroDePontos, tipoDePonto);
	}
	
	public String getAllUserPoints(String user) {
		String returnString = "User:" + user;
		ArrayList<String> typeList = arm.returnsAllPointTypes();
		for(String currentType : typeList) {
			int currentPoints = arm.getsPointsByType(user, currentType);
			if(currentPoints != 0) {
				returnString += " " + currentType + ":" + currentPoints;
			}
		}
		return returnString;
	}
	
	public String getPointRanking(String pointType) {
		ArrayList<String> userList = arm.returnsAllUsers();
		List<String> rank = new ArrayList<String>();
		for(String user : userList) {
			int userPoints = arm.getsPointsByType(user, pointType);
			if(userPoints != 0) {
				String userString = userPoints + " " + user;
				rank.add(userString);
			}
		}
		
		Collections.sort(rank, new Comparator<String>() {
	        @Override
	        public int compare(String userString1, String userString2) {
	        	int points1 = Integer.parseInt(userString1.split(" ")[0]);
	        	int points2 = Integer.parseInt(userString2.split(" ")[0]);
	            return points2 - points1;
	        }
	    });
		
		String returnString = "";
		for(String user : rank) {
			returnString += user + "\n";
		}
		
		return returnString;
	}

}	
