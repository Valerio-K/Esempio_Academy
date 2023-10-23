package com.business;

import java.util.Scanner;

import com.bean.BirthDate;
import com.dto.IscrittiDTO;

public class Input {
	
	public static final Scanner scan = new Scanner(System.in);
	
	public static IscrittiDTO InputDTO(String message) {
		System.out.println(message);
		IscrittiDTO iscrittiDTO = new IscrittiDTO(scan.nextLine(),
				scan.nextLine(), new BirthDate(Integer.valueOf(scan.nextLine()),
				Integer.valueOf(scan.nextLine()), Integer.valueOf(scan.nextLine()), scan.nextLine()), scan.nextLine());
		return iscrittiDTO;
	}
	
	public static int InputID(String message) {
		System.out.println(message);
		int id = Integer.valueOf(scan.nextLine());
		return id;
	}
	
	public static String searchInput(String message) {
		System.out.println(message);
		String filter = scan.nextLine();
		return filter;
	}
}
