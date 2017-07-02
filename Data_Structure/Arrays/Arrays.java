/*
按照线性顺序来组织固定数量(Fixed amount)的数组，支持数组的插入，删除，搜索，遍历，定位，等操作。
它是在
	java.util
包下面的一个类
*/

public class Solution {
	public void main(String[] args) {
		int[] numArray = new int[10];
		for (int i = 0; i < 10; i++) {
			numArray[i] = i;
		}

		for (int i = 0; i < 10; i++) {
			System.out.print(numArray[i] + " ");
		}

		System.out.println("");
	}
}

//当数组需要保存实例时，它所保存的，只是指向那实例的一个引用地址，而不是该实例本身

//数组的元素只能是基础数据类型(Primitive types)或者是实例的引用，如果需要复制的类型是primitive types,则直接复制到新数组即可。
//但如果是实例到引用，则问题就稍微复杂：

public class Solution {
	private static class Person {
		String name;
		int age;
		public Person(String name, int age){
			this.name = name;
			this.age = age;
		}
	}

	public static void main(String[] args) {
		Person[] p1 = new Person[1];
		p1[0] = new Person("Tom", 13);
		//p1[1] = new Person("Jerry", 14);
		Person[] p2 = new Person[1];
		p2 = Arrays.copyOf(p1, 1);

		System.out.println(p1[0].name);
		System.out.println(p2[0].name);

		p1[0].name = "Mary";

		System.out.println(p1[[0].name);
		System.out.println(p2[0].name);
	}
}


/*
output:
	Tom
	Tom
	Mary
	Mary
*/

/*
新复制的数组元素，在默认的情况下，复制的也是相应实例的引用，两个引用指向一个地址，任何一个数组操作改变了那个地址的实例内容，另一个数组的对应元素也会相应变化。
*/

/*
这种情况下，数组元素之乡的实际内容，也就是该实例，其实并没有被“复制”，被复制的知识它的引用。这种复制，叫做“浅复制”。		
*/


/*
注意String的特殊性，因为是invariable，虽然本质是pass by reference,
*/

public class Solution {
	public static void main(String[] args) {
		String[] a1 = new String[1};
		a1[0] = "Tom";
		String[] a2 = a1.clone();
		System.out.println(a1[0]);
		System.out.println(a2[0]);

		a1[0] = "Mary";	//Assigned to a new address
		System.out.println(a1[0]);
		System.out.println(a2[0]);
	}
}



















