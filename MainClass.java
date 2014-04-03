import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * clasa main pentru test
 * 
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashMapImpl<Student, Integer> stud = new MyHashMapImpl<Student, Integer>(
				10);
		MyHashMapImpl<LazyStudent, Integer> lazystud = new MyHashMapImpl<LazyStudent, Integer>(
				10);
		ArrayList<Student> listastud = new ArrayList<Student>();
		ArrayList<LazyStudent> listalazy = new ArrayList<LazyStudent>();
		Random generator = new Random();

		for (int i = 0; i < 2000; i++) {
			Student s = new Student(
					Long.toString(Math.abs(generator.nextLong())),
					generator.nextInt());
			listastud.add(s);
			stud.put(s, generator.nextInt());
		}
		long timp = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			stud.get(listastud.get(i));
		}
		System.out.println(System.currentTimeMillis() - timp);

		for (int i = 0; i < 2000; i++) {
			LazyStudent s = new LazyStudent(Long.toString(Math.abs(generator
					.nextLong())), generator.nextInt());
			listalazy.add(s);
			lazystud.put(s, generator.nextInt());
		}
		timp = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			lazystud.get(listalazy.get(i));
		}
		System.out.println(System.currentTimeMillis() - timp);
	}

}
