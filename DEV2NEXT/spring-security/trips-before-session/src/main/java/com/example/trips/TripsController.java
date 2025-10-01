package com.example.trips;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trips")
public class TripsController {

  private final TripRepository tripRepository;

  public TripsController(TripRepository tripRepository) {
    this.tripRepository = tripRepository;
  }

  @GetMapping
  public String listTrips(Model model, @AuthenticationPrincipal UserDetails user) {
    var traveler = user.getUsername();
    model.addAttribute("trips", tripRepository.findByTraveler(traveler));
    return "tripList";
  }

}
