package com.mycompnay.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		
		String name = "vikas vikas k";
		Map<String,Long> wordsCount = Arrays.stream(name.split("\\s+")).map(String::toLowerCase).collect(Collectors.groupingBy(item->item,Collectors.counting()));
		System.out.println("words count :::" + wordsCount);
		
		
		Map<Character,Long> letterCount = name.chars().mapToObj(letter->(char)letter).filter(item->!Character.isWhitespace(item))
				.collect(Collectors.groupingBy(item->item,Collectors.counting()));
		System.out.println("lettercount::" + letterCount);
		
		List<Integer> l1 = new ArrayList<>(Arrays.asList(1,2,2,3,4));
		List<Integer> l2 = new ArrayList<>(Arrays.asList(1,2,2,3,4,5,6));
		
		
		List<Integer> combinedList = new ArrayList<>(l1);
		combinedList.addAll(l2);
		
		Set<Integer> s2= combinedList.stream().distinct().collect(Collectors.toSet());
		
		
		Set<Integer> s1= Stream.of(l1,l2).flatMap(List::stream).distinct().collect(Collectors.toSet());
		System.out.println("unique elements ::"+s1);
		
		List<Integer> evenNumbers = combinedList.stream().filter(item->item%2 == 0).collect(Collectors.toList()); //to find even numbers
		
		List<String> oneNumbers = combinedList.stream().map(item->item+"").filter(s->s.startsWith("1")).collect(Collectors.toList()); //to find one value numbers
		
		
			Set<Integer> duplicateEle = new HashSet();
			combinedList.stream().filter(item->!duplicateEle.add(item)).forEach(System.out::println); //to collect duplicate elements
			
			
			Optional<Integer> firstEle = combinedList.stream().findFirst();
			System.out.println("first ele "+firstEle.get());
		
			
			Long count = combinedList.stream().count(); //count the number of elements in the given list
			System.out.println("count "+count);
			
			
			Integer maxValue = combinedList.stream().max((num1,num2)->num1-num2).get(); //to get max value
			Integer minValue = combinedList.stream().min((num1,num2)->num1-num2).get(); //to get max value
			
			System.out.println("maxvalue:::"+maxValue);
			System.out.println("minvalue :: "+minValue);
			
			List<String> courses = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
			
			
			
			List<String> uniqueElements = courses.stream().distinct().collect(Collectors.toList());
			
			System.out.println("unique elements from list of strings "+uniqueElements);
			
			Map<String,Long> frequencyOfElement = courses.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
			
			System.out.println("frequency of each element in list of strings :: "+frequencyOfElement);
			
			List<Integer> reverseOrder = combinedList.stream().sorted(Comparator.reverseOrder()).toList();
			System.out.println("reverse order list :: "+reverseOrder.get(1));
			List<Integer> naturalOrder = combinedList.stream().sorted(Comparator.naturalOrder()).toList();
			System.out.println("reverse order list :: "+naturalOrder);
			
			
			
			
			Integer secondLargestNumber = combinedList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
			System.out.println("Second Largest Number :: "+secondLargestNumber);
			
			
			
			
			Employee e1 =  new Employee("vikas",24,12000);
			Employee e2 =  new Employee("vikas",24,14000);
			Employee e3 =  new Employee("vikas",24,16000);
			Employee e4 =  new Employee("vikas",24,18000);
			
			List<Employee> empList = Arrays.asList(e1,e2,e3,e4);
			
			Employee secondHighestSal = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst().get();
			
			
			 System.out.println("Secound Highest salary :: "+secondHighestSal.getSalary());
			 
			 
			 TreeSet<String> set = new TreeSet<String>((str1,str2)->str1.length() - str2.length()); //comparator is ment for custom sorting contains compare takes 2 args
	}
}


