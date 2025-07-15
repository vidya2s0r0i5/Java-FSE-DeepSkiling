package com.cognizant.spring_learn;

import com.cognizant.spring_learn.model.CountryModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    public CountryModel getCountry(String code) {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<CountryModel> countries = (List<CountryModel>) context.getBean("countryList");

        // Using Stream + Lambda for case-insensitive match
        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}
