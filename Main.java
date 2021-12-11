import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;


public class Zapis {

	public static void main(String[] args) throws IOException {
		Osoba o1 = new Osoba("Adam", "Mickiewicz", 1798);
		Osoba o2 = new Osoba("Juliusz", "Slowacki", 1809);
		
	
		FileOutputStream fos = new FileOutputStream("plik.ser");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		oos.writeObject(o1);
		oos.writeObject(o2);
		
		oos.close();
		
		FileInputStream fis = new FileInputStream("plik.ser");
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
				
		while(bis.available() > 0) {
			Osoba o = (Osoba) ois.readObject();
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
