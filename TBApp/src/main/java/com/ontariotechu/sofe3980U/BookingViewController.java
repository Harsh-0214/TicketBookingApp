package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

// Model Imports:
import com.ontariotechu.sofe3980U.core.Memory;

@Controller
public class BookingViewController {

    @GetMapping("/")
    public String home(Model model) {

        Memory memoryStore = Memory.getInstance(); 

        model.addAttribute("airports", memoryStore.getAirportList()); 

        return "booking_view";
    }

    @GetMapping("/bookings")
    public String bookings(Model model) {
        return "tickets_view";
    }


}