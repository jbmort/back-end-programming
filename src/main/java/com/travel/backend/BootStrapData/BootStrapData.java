package com.travel.backend.BootStrapData;

import com.travel.backend.dao.CustomerRepository;
import com.travel.backend.dao.DivisionRepository;
import com.travel.backend.entities.Customer;
import com.travel.backend.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private CustomerRepository customerRepository;
    private DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository,
                        DivisionRepository divisionRepository
                         ){
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(customerRepository.count() <= 1) {

            Division d1 = divisionRepository.getReferenceById(31L);
            Customer c1 = new Customer("Mike", "Ross", "1511 South St.", "12345", "1234567890");
            c1.setDivision(d1);

            Division d2 = divisionRepository.getReferenceById(14L);
            Customer c2 = new Customer("Mark", "Simple", "123 North St.", "12345", "2234534890");
            c2.setDivision(d2);

            Division d3 = divisionRepository.getReferenceById(25L);;
            Customer c3 = new Customer("Russ", "Jenkins", "345 Rough Rd.", "67890", "3534567493");
            c3.setDivision(d3);

            Division d4 = divisionRepository.getReferenceById(32L);
            Customer c4 = new Customer("Ronnie", "Coleman", "914 Beach St.", "12345", "098767890");
            c4.setDivision(d4);

            Division d5 = divisionRepository.getReferenceById(101L);
            Customer c5 = new Customer("Sherlock", "Holmes", "221B Baker St.", "NW16XE", "1234567890");
            c5.setDivision(d5);

            customerRepository.save(c1);
            customerRepository.save(c2);
            customerRepository.save(c3);
            customerRepository.save(c4);
            customerRepository.save(c5);}
        }
}
