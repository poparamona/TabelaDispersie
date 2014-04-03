/**
 * 
 * clasa student cu metodele hashCode si equals
 * 
 */
public class Student {
	String nume;
	int varsta;

	/**
	 * constructor pentru nume si varsta
	 * 
	 * @param nume
	 *            in sir
	 * @param varsta
	 *            un intrg
	 */
	public Student(String nume, int varsta) {
		this.nume = nume;
		this.varsta = varsta;
	}

	/**
	 * metoda equals returneaza true daca obiectul pentru care se apeleaza este
	 * echivalent cu obiectul primit ca parametru.Echivalenta inseamna nume si
	 * varsta identice
	 * 
	 * @param Object
	 *            o un obiect
	 * @return true daca daca nume si varsta pentru care se apeleaza este
	 *         echivalent cu nume, varsta primit ca parametru, altfel false
	 */
	@Override
	public boolean equals(Object o) {
		if (this.nume.equals(((Student) o).nume)) {
			if (((Student) o).varsta == this.varsta)
				return true;
		}
		return false;
	}

	/**
	 * metoda hashCode ce returneaza hashul dupa formula data
	 * 
	 * @param nu
	 *            are parametri
	 * @return Hash
	 */
	@Override
	public int hashCode() {
		int hash = 17;
		hash = 37 * hash + nume.hashCode();
		return hash;
	}

}

/* clasa ce extinde student */
class LazyStudent extends Student {

	/**
	 * constructor pentru nume si varsta
	 * 
	 * @param nume
	 *            un string
	 * @param varsta
	 *            un integer
	 */
	public LazyStudent(String nume, int varsta) {
		super(nume, varsta);
		// TODO Auto-generated constructor stub
	}

	/**
	 * metoda ce returneaza mereu o constanta
	 */
	@Override
	public int hashCode() {
		return 5;
	}
}