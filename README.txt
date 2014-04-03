Pentru prima parte a temei "Implementare" am creat clasa MyHashMapImpl care implementeaza MyHashMap, conservand genericitatea.
In aceasta clasa se gaseste implementarea interfetelor Entry si Bucket.
Constructorul MyHashMapImp primeste parametrul "n" si adauga in Array List n buchete.
Metoda get primeste ca parametru o cheie si returneaza valuarea sau null , gasind indexul din hashCode dupa formula din enunt.
Metoda puts : Metoda care gaseste indexu din hashCode si daca nu exista valuare in buchet o adauga altfel, daca cheia este cea data ca parametru ia valuarea asociata cheii, o sterge si adauga noua valuare
Metoda remove are ca parametru o cheie si returneaza valuarea stearsa asociata cheii sau null.
Constructorul size fara parametrii, intoarce dimensiunea tabelei.

Pentru a doa parte a temei "Analiza" am creat clasa Student care contine membrii nume si varsta, constructorii student si lazystudent, dar si metodele equals si hashCode.
Clasa Lazy Student care extinde student contine si contine la randul ei o metoda hashCode care returneaza o constanta.
Metoda equals din student are parametru de tip Object si intoarce true daca obiectul pentru care se apeleaza este echivalent cu obiectul primit ca parametru. In cazul nostru echivalenta inseamna nume si varsta identice. 
Metoda hashCode din clasa student redurneaza hashul dupa formula data.

Clasa Main:

Am generat un numar mare de instante Student (>1000) (cu membrii generati aleator) si le-am introdus intr-o lista.
Am parcurs lista si am introdus studentii intr-un MyHashMap<Student, Integer>, unde valorile sunt note.
Am facut un numar mare de accesari aleatoare ale tabelei create (get), folosind drept chei instantele Student create mai devreme.

Ce observati?
Se observa ca timpul este mult mai mare pentru tabela lazystud datorita dispunerii intr-o singura lista liniara a tuturor perechilor cheie-valoare (entry-uri) din tabela, pecand in celalalt caz acestea sunt grupate in mai multe subliste (bucket-uri), pe baza unui anumit criteriu accesul fiind mai rapid



























