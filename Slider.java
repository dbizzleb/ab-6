package ab6;

public class Slider {
		  public static void main(String[] args) {
			    int[][] feld = new int[4][4];
			    feld = anfangsFeld(feld);
			    ausgeben(feld);

			    while(!fertig(feld)){
			      feld = tauschen(feld);
			      ausgeben(feld);
			    }
			    System.out.println("Du hast gewonnen.");
			  }

			  static int[][] anfangsFeld(int[][] kasten){ //Array wird mit Anfangswerten gefüllt
			    kasten[0][0] = 4;
			    kasten[0][1] = 1;
			    kasten[0][2] = 2;
			    kasten[0][3] = 3;
			    kasten[1][0] = 0;
			    kasten[1][1] = 5;
			    kasten[1][2] = 6;
			    kasten[1][3] = 7;
			    kasten[2][0] = 8;
			    kasten[2][1] = 9;
			    kasten[2][2] = 10;
			    kasten[2][3] = 11;
			    kasten[3][0] = 12;
			    kasten[3][1] = 13;
			    kasten[3][2] = 14;
			    kasten[3][3] = 15;
			    return kasten;
			  }

			  static int[][] fertigesSpielfeld(int[][] kasten){ //Fertiges Spielfeld wird gebaut
			    int wert = 0;
			    for (int zeile = 0; zeile<kasten.length; zeile++){
			      for(int spalte = 0; spalte<kasten[zeile].length; spalte++){
			          kasten[zeile][spalte] = wert;
			        wert++;
			      }
			    }

			    return kasten;
			  }

			  static void ausgeben(int[][] kasten){ //Arrays werden mit Umrandung ausgegeben
			    System.out.println(" 0  1  2  3");

			    for (int zeile = 0; zeile<kasten.length; zeile++){
			      System.out.println("+--+--+--+--+");
			      for(int spalte = 0; spalte<kasten[zeile].length; spalte++){
			        if(kasten[zeile][spalte]<10){
			          System.out.print("| " + kasten[zeile][spalte]);
			        }else{
			          System.out.print("|" + kasten[zeile][spalte]);
			        }
			      }
			      System.out.print("|");
			      System.out.println("");
			    }
			    System.out.println("+--+--+--+--+");
			  }

			  static boolean fertig(int[][] aktuellesFeld){
			    int[][] fertigesFeld = new int[4][4];
			    fertigesFeld = fertigesSpielfeld(fertigesFeld);
			    int zaehler = 0;
			    for (int zeile = 0; zeile<aktuellesFeld.length; zeile++){
			      for(int spalte = 0; spalte<aktuellesFeld[zeile].length; spalte++){

			        if (aktuellesFeld[zeile][spalte] == fertigesFeld[zeile][spalte]){
			          zaehler++;
			        }
			      }
			    }
			    if (zaehler==15)
			      return true;
			    else
			      return false;
			  }

			  static int[][] tauschen(int[][] kasten){
			    int nullZeile = 0;
			    int nullSpalte = 0;
			    int zeile;
			    int spalte;
			    int wert;

			    for (int i = 0; i<kasten.length; i++){ //Koordinaten von dem 0 Feld werden gesucht
			      for(int j = 0; j<kasten[i].length; j++){
			        if (kasten[i][j] == 0){
			          nullZeile = i;
			          nullSpalte = j;
			        }
			      }
			    }

			    do{
			      zeile = IO.readInt("Zeile: ");
			      spalte = IO.readInt("Spalte: ");
			    } while((zeile < 0 || zeile > 3) || (spalte < 0 || spalte > 3));

			    if (tauschErlaubt(nullZeile, nullSpalte, zeile, spalte) ){
			      wert = kasten[zeile][spalte];	//Zwischenspeichern
			      kasten[zeile][spalte] = 0;
			      kasten[nullZeile][nullSpalte] = wert;  //Tauschprozess
			    }
			    return kasten;
			  }

			  static boolean tauschErlaubt(int nullZ, int nullS, int z, int s){
			    if(((z - nullZ == 1 || z - nullZ == -1) && (s == nullS)) || ((s - nullS== 1 || s - nullS == -1) && (z == nullZ))){
			      return true;
			    }else{
			      System.out.println("Du kannst nur mit den Nachbarfeldern tauschen.");
			      return false;
			    }
			  }

			
	}

