package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryService.class);

    public Country getCountry(String code) {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countries =
                context.getBean("countryList", List.class);

        for (Country country : countries) {

            if (country.getCode().equalsIgnoreCase(code)) {

                LOGGER.debug("Country found : {}", country);
                LOGGER.info("END");

                return country;
            }
        }

        LOGGER.info("END");

        throw new CountryNotFoundException(
                "Country not found for code: " + code
        );
    }
}