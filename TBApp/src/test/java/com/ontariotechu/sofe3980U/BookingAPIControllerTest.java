package com.ontariotechu.sofe3980U;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontariotechu.sofe3980U.core.restmodels.BookingSubDTO;
import com.ontariotechu.sofe3980U.core.restmodels.FlightSearchDTO;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.runner.RunWith;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;
import static org.hamcrest.Matchers.containsString;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import com.ontariotechu.sofe3980U.core.restmodels.FlightSearchDTO;
import org.springframework.http.MediaType;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@WebMvcTest(BookingAPIController.class)
public class BookingAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test_search_flight_1() throws Exception {
        FlightSearchDTO fsDTO = new FlightSearchDTO();
        fsDTO.setDepartureAirport(1);
        fsDTO.setDepartureDate("01/01/2021");
        fsDTO.setRoundTrip(false);
        fsDTO.setArrivalAirport(2);

//Converting DTO to JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String fsDTOJson = objectMapper.writeValueAsString(fsDTO);
        this.mvc.perform(post("/search_flights")
                .contentType(MediaType.APPLICATION_JSON)
                .content(fsDTOJson))
                .andExpect(status().isOk());
    }
    @Test
    public void test_submit_booking_1() throws Exception {
        BookingSubDTO bsDTO = new BookingSubDTO();
        bsDTO.setBookingUUID("1234");
        bsDTO.setUserName("Harsh T");
        bsDTO.setUserUUID("0214");
        ObjectMapper objectMapper = new ObjectMapper();
        String fsDTOJson = objectMapper.writeValueAsString(bsDTO);
        this.mvc.perform(post("/submit_booking")
                .contentType(MediaType.APPLICATION_JSON)
                .content(fsDTOJson))
                .andExpect(status().is4xxClientError());
    }
}