import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Osoba o1 = new Osoba("Adam", "Mickiewicz", 1798);
		Osoba o2 = new Osoba("Juliusz", "Slowacki", 1809);
    Osoba o3 = new Osoba("Michał", "Bochenek", 1982);

    
    ArrayList<Osoba> lista = new ArrayList<Osoba>();
    //dodanie dwoch obiektow do arraylisty
    lista.add(o1);
    lista.add(o2);
    lista.add(o3);
    
	//serializacja - zapisujemy do pliku cale obiekty (nie pliki tesktowe tylko binarne) - roszerzenie nie ma znaczenia
		FileOutputStream fos = new FileOutputStream("plik.ser");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		//po opakowaniu pliku w BufferedOutputStream i ObjectOutputStream mozna korzystac z tych metod - writeobject
		oos.writeObject(lista);
		//oos.writeObject(o2);
		
		oos.close();
		//czytanie z pliku obiektow
		FileInputStream fis = new FileInputStream("plik.ser");
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
			//czytanie w petli do konca pliku	
		while(bis.available() > 0) {//sprawdzenie konca pliku
			ArrayList<Osoba> o = (ArrayList<Osoba>) ois.readObject();//czytanie obiektu - konwersja 
			System.out.println(o);
		}
		
		ois.close();

	}
}


/* Zadania:
 * 1. Utworz liste ArrayList<Osoba>.
 * 2. Dodaj do niej dwa obiekty klasy Osoba.
 * 3. Otworz kolejny plik do zapisu i zapisz do niego obiekt klasy ArrayList<Osoba>.
 * 4. Wczytaj obiekt klasy ArrayList<Osoba> z drugiego pliku.
 * 5. Wyswietl go na ekranie.
 */
