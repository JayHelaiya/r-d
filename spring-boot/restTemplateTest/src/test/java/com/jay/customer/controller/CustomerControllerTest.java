package com.jay.customer.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.jay.customer.model.Customer;
import com.jay.customer.service.CustomerWelcomer;

/**
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    CustomerWelcomer customerWelcomer;
    
    private final String URL = "/getAllCustomer/";

/*
    @Test
    public void testGetAllCustomer() throws Exception {

        // prepare data and mock's behaviour
        List<Customer> custList = buildCustomers();
        when(customerService.getAllCustomers()).thenReturn(custList);

        // execute
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/getAllCustomers").accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        
        String response = result.getResponse().getContentAsString();
        
        System.out.println(response);

        int status = result.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status, "Incorrect Response Status");


    }
*/
    
    
    
    private List<Customer> buildCustomers() {
    	Customer c1 = new Customer();
    	Customer c2 = new Customer();
    	
    	c1.setCustomerName("jayesh");
    	c1.setEmail("dip@gmail.com");
    	
    	c2.setCustomerName("jayesh");
    	c2.setEmail("jay@gmail.com");
        List<Customer> custList = Arrays.asList(c1, c2);
        return custList;
    }
    
    private Customer buildCustomers1() {
    	Customer c2 = new Customer();
    	
    	c2.setCustomerName("jayesh");
    	c2.setEmail("jay@gmail.com");
       
        return c2;
    }
    
    
    @Test
    public void welcomTest() {
    	 when(customerWelcomer.welcome()).thenCallRealMethod();
    	String welcome = customerWelcomer.welcome();
    	System.out.println(welcome);
	}
}
