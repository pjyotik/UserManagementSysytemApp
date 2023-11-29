package com.pjyotik.dev.ums.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@SpringBootTest
class UserManagementSystemApplicationTests {

	private List<String> getCountries(){
		List<String> countryNames = new ArrayList<>();
		// Convert country codes to country names
		for (String countryCode : Locale.getISOCountries()) {
			Locale locale = new Locale("", countryCode);
			String cName = locale.getDisplayCountry();
			countryNames.add(cName);
		}
		return countryNames;
	}
	@Test
	void contextLoads() {
		List<String> countries = getCountries();
		countries.forEach(System.out::println);
	}

}
