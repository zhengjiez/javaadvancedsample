public class Test {
	/* 
	 * 
	 */

	public static void main(String []args) {
        String first = "Zhengjie Zhu";
        String second = "Oystein";
        String third = "Trine";

        StringList<String> strlist = new StringList<String>(3);

        strlist.add(first);
        strlist.add(second);
        strlist.add(third);

        System.out.println(strlist.get(0));
        System.out.println(strlist.length());
        
	}
}

