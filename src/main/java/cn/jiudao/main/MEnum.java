package cn.jiudao.main;

import java.util.EnumSet;

public enum MEnum {
	WEST("11",3),
	NORTH("222",5);

	private String description;
	private int x;
	
	private MEnum(String description,int x){
		this.description = description;
		this.x = x;
	}
	
	public String getDes(){
		return description;
	}
	
	public static void main(String[] args) {
//		for (MEnum en : MEnum.values()) {
//			System.out.println(en.hashCode());
//			System.out.println(en.ordinal());
//			System.out.println(en.name());
//			System.out.println(en.getDes());
//			System.out.println(en.getDeclaringClass());
//			System.out.println("///");
//		}
		
		EnumSet<MEnum> enumSets = EnumSet.noneOf(MEnum.class);
		System.out.println(enumSets.size());
		enumSets = EnumSet.allOf(MEnum.class);
		System.out.println(enumSets.size());
	}
}
