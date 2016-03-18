package cn.jiudao.main;

public class MyTest {

	public final static TT x = new TT();
	
	public static void main(String[] args) {
		x.print();
		x.add();
		System.out.println(x.i);
	}
	
	public static class TT {
		private int i =0;
		public TT(){}
		public void add(){
			i = 4;
		}
		public void print(){
			System.out.println(i);
		}
	}
}
