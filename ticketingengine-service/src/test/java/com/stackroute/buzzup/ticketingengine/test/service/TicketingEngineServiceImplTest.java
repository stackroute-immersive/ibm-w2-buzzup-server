package com.stackroute.buzzup.ticketingengine.test.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.buzzup.ticketingengine.exceptions.TicketCannotGenerateException;
import com.stackroute.buzzup.ticketingengine.model.TicketingEngine;
import com.stackroute.buzzup.ticketingengine.repository.TicketingEngineRepository;
import com.stackroute.buzzup.ticketingengine.service.TicketingEngineServiceImpl;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@WebMvcTest
@RunWith(SpringRunner.class)

public class TicketingEngineServiceImplTest {
	private TicketingEngine ticketingEngine;
    @Mock
    private TicketingEngineRepository ticketingEngineRepository;
    @MockBean
    private TicketingEngineServiceImpl ticketingEngineServiceImpl;
    
    TicketingEngine options;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        //ticketingEngine = new TicketingEngine();
        TicketingEngine ticketingEngine=new TicketingEngine();
        ticketingEngine.setId(12);
        ticketingEngine.setName("Cricket-Category");
        ticketingEngine.setDescription("All about Cricket");
      /*  ticketingEngine.setCreatedBy("Jhon123");
        ticketingEngine.setCreationDate(new Date());
*/
      /*  allCategories = new ArrayList<>();
        allCategories.add(category);*/ 
        //options = Optional.of(ticketingEngine);
    }

    @Test
    public void generateTicketSuccess() throws TicketCannotGenerateException   {
        when(ticketingEngineRepository.insert((TicketingEngine) any())).thenReturn(ticketingEngine);
        TicketingEngine status = ticketingEngineServiceImpl.generateTicket(ticketingEngine);
        Assert.assertEquals(ticketingEngine, status);   
    }

    @Test
    public void generateTicketFailure() throws TicketCannotGenerateException {
        when(ticketingEngineRepository.insert((TicketingEngine) any())).thenReturn(ticketingEngine);
        TicketingEngine status = ticketingEngineServiceImpl.generateTicket(ticketingEngine);
        Assert.assertEquals(ticketingEngine, status);
    }
}


