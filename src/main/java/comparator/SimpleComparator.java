package comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SimpleComparator {
	public static void main(String ...args){

		List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));

		Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

		// [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
		inventory.sort(c);
		System.out.println(inventory);
	}


	public static class Apple {
		private int weight = 0;
		private String color = "";

		public Apple(int weight, String color){
			this.weight = weight;
			this.color = color;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String toString() {
			return "Apple{" +
					"color='" + color + '\'' +
					", weight=" + weight +
					'}';
		}
	}

}