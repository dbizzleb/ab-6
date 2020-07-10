package ab6;

public class aufgabe1 {
	
		static String[]arrStaedte;
		static String[][]arrVerbindungen;		

		public static void main(String[] args) 
		{
			int anz = IO.readInt("Anzahl Staedte:");
			arrStaedte = new String[anz];
			for (int i = 0; i < anz; i++) 
			{
				arrStaedte[i]=IO.readString(i+1+". Stadt:");
			}
			anz= IO.readInt("Anzahl Verbindungen:");
			arrVerbindungen = new String[anz][2];
			for (int j = 0; j < anz; ) 
			{
				System.out.println("Direktverbindung:"+(j+1));
				String vStart = IO.readString("Start:");
				String vZiel = IO.readString("Ziel:");
				if (!überprüfen(vStart) || !überprüfen(vZiel)) 
				{
					continue;
				}
				arrVerbindungen[j][0]=vStart;
				arrVerbindungen[j][1]=vZiel;
				j++;
			}
			System.out.println("Auskunft");
			String aStart=IO.readString("Start:");
			String aZiel=IO.readString("Ziel:");
			System.out.println(auskunft(aStart,aZiel));
		}
		static boolean überprüfen(String Start)
		{
			for (int j = 0; j < arrStaedte.length; j++) 
			{
				if(Start.equals(arrStaedte[j]))
				{
					return true;
				}
			}
			return false;
		}
		static String auskunft(String start,String ziel)
		{
			for (int j = 0; j < arrVerbindungen.length; j++) 
			{
				if(start.equals(arrVerbindungen[j][0])&& ziel.equals(arrVerbindungen[j][1]))
				{
					return "Es besteht eine Verbindung zwischen "+start+" und "+ziel;
				}
				if(start.equals(arrVerbindungen[j][1])&& ziel.equals(arrVerbindungen[j][0]))
				{
					return "Es besteht eine Verbindung zwischen "+start+" und "+ziel;
				}
			}
			return "Es besteht keine Verbindung zwischen "+start+" und "+ziel;
		}

	}

	
	
