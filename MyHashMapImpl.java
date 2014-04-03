import java.util.*;

/**
 * clasa MyhashMapImp care implementeaza interfata MyHashMap
 */

public class MyHashMapImpl<K, V> implements MyHashMap<K, V> {
	/* Arraylist de bucheturi */
	ArrayList<BucketImpl> bucketuri;
	/* numar de bucheturi in Hashmap */
	int nrBuckets;

	/**
	 * constructor in care initializez un Arraylist de bucheturi ,prin care ma
	 * plimb si adaug cele n buchete
	 * 
	 * @param n
	 *            un intreg care reprezinta numarul de bucheturi @ return nu
	 *            returneaza nimic ,este un constructor
	 */
	public MyHashMapImpl(int n) {
		bucketuri = new ArrayList<BucketImpl>(n);
		for (int i = 0; i < n; i++) {
			bucketuri.add(new BucketImpl());
		}
		this.nrBuckets = n;
	}

	/**
	 * metoda care returneaza valuarea unei intrari din buchet care se
	 * potriveste cu cheia data ca parametru sau null. Gaseste indexul din
	 * HashCod
	 * 
	 * @param k
	 *            key o chee
	 * @return null daca nu exista in buchet intrarea respectiva sau in caz
	 *         contrar valuarea care se potriveste cu cheia data ca parametru
	 */

	@Override
	public V get(K key) {
		int index = Math.abs(key.hashCode()) % nrBuckets;
		BucketImpl bucket = bucketuri.get(index);
		if (bucket.getEntries().isEmpty())
			return null;
		for (int i = 0; i < bucket.getEntries().size(); i++)
			if (bucket.getEntries().get(i).getKey().equals(key))
				return bucket.getEntries().get(i).getValue();
		return null;
	}

	/**
	 * Metoda care gaseste indexu din hashCode si daca nu exista valuare in
	 * buchet o adauga altfel, daca cheia este cea data ca parametru ia valuarea
	 * asociata cheii, o sterge si adauga noua valuare
	 * 
	 * @param k
	 *            key o cheie
	 * @param v
	 *            value valuarea asociata cheii
	 * @return val vechiul element sau null
	 */

	@Override
	public V put(K key, V value) {
		int index = Math.abs(key.hashCode()) % nrBuckets;
		BucketImpl bucket = bucketuri.get(index);
		if (bucket.getEntries().isEmpty()) {
			bucket.entryuri.add(new EntryImpl(key, value));
			return null;
		}
		for (int i = 0; i < bucket.getEntries().size(); i++)
			if (bucket.getEntries().get(i).getKey().equals(key)) {
				V val = bucket.getEntries().get(i).getValue();
				bucket.entryuri.remove(i);
				bucket.entryuri.add(new EntryImpl(key, value));
				return val;
			}
		bucket.entryuri.add(new EntryImpl(key, value));
		return null;
	}

	/**
	 * metoda ce gaseste indexul din hashCode si daca nu exista valuare in
	 * buchet returneaza null daca cheia este cea data ca parametru ia valuarea
	 * asociata si o sterge
	 * 
	 * @param k
	 *            key o cheie
	 * @return val valuarea stearsa sau null
	 */

	@Override
	public V remove(K key) {
		int index = Math.abs(key.hashCode()) % nrBuckets;
		BucketImpl bucket = bucketuri.get(index);
		if (bucket.getEntries().isEmpty())
			return null;
		for (int i = 0; i < bucket.getEntries().size(); i++)
			if (bucket.getEntries().get(i).getKey().equals(key)) {
				V val = bucket.getEntries().get(i).getValue();
				bucket.entryuri.remove(i);
				return val;
			}
		return null;
	}

	/**
	 * Constructor ce intoarce dimensiunea tabelei.
	 * 
	 * @param nu
	 *            are este constructor
	 * @return size dimensiunea
	 */
	@Override
	public int size() {
		int size = 0;
		for (int i = 0; i < bucketuri.size(); i++)
			size = size + bucketuri.get(i).getEntries().size();
		return size;
	}

	/**
	 * Intoarce lista de bucket-uri din tabela.
	 * 
	 * @return bucheturi
	 */
	@Override
	public List<? extends MyHashMap.Bucket<K, V>> getBuckets() {
		// TODO Auto-generated method stub
		return bucketuri;
	}

	/**
	 * Clasa EntryImp ce implementeaza interfata
	 */
	class EntryImpl implements MyHashMap.Entry<K, V> {
		K key;
		V value;

		/**
		 * constructor ce initializeaza key si val
		 * 
		 * @param k
		 *            key o cheie
		 * @param val
		 *            valuarea cu cheia asociata
		 * 
		 */
		EntryImpl(K key, V val) {
			this.key = key;
			this.value = val;
		}

		/**
		 * metoda ce returneaza cheia
		 * 
		 * @param nu
		 *            are parametri
		 * @return key cheia
		 */
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		/**
		 * metoda care returneaza valuarea
		 * 
		 * @param nu
		 *            are parametri
		 * @return value valuarea
		 */
		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}
	}

	class BucketImpl implements MyHashMap.Bucket<K, V> {
		/* ArrayList de intrari */
		ArrayList<EntryImpl> entryuri;

		/* constructor fara parametri, aloca spatiu pentru lista */
		BucketImpl() {
			entryuri = new ArrayList<EntryImpl>();
		}

		/* intoarce lista de intrari continuta de acel buchet */
		@Override
		public List<? extends MyHashMap.Entry<K, V>> getEntries() {
			// TODO Auto-generated method stub
			return entryuri;
		}

	}

}
