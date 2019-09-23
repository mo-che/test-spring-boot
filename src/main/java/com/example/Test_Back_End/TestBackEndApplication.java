package com.example.Test_Back_End;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestBackEndApplication.class, args);
		Scanner scan = new Scanner(System.in);
		System.out.print("input :");
		String input = scan.nextLine();
		System.out.println("output :"+decompress(input));
		scan.close();
	}

	public static String decompress(String str) {
		return decompress(str, 1);
	}

	private static String decompress(String str, int num) {
		String num_text = "";
		String out = "";
		int count = 0;
		for (int i = 0;i < str.length();i++) {
			if (Character.isDigit(str.charAt(i))) {
				num_text += str.charAt(i);
			}else if (str.charAt(i) == '[') {
				if(count==0){
					out += decompress(str.substring(i+1),Integer.parseInt(num_text));
				}
				num_text = "";
				count++;
			}else if (str.charAt(i) == ']') {
				if(count == 0){
					String tmp = out;
					while(num > 1){
						out += tmp;
						num--;
					}
					return out;
				}
				count--;
			}else{
				if(count==0){
					out += str.charAt(i);
				}
			}
		}
		return out;
	}
}
