package com.sda.project.bookingapp.controller;

import com.sda.project.bookingapp.model.NewsletterModel;
import com.sda.project.bookingapp.model.PropertyModel;
import com.sda.project.bookingapp.model.SearchPropertyModel;
import com.sda.project.bookingapp.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/search/property/{propertyId}/address/{addressId}")
    public ModelAndView searchPropertyById(@PathVariable("propertyId") Long propertyId,
                                           @PathVariable("addressId") Long addressId ) {
        PropertyModel propertyModel = propertyService.getPropertyByIdAndAddressId(propertyId, addressId);
        
        return new ModelAndView("propert-detail")
                .addObject("SearcPropertyModel", new SearchPropertyModel())
                .addObject("propertyModel", propertyModel);
    }
}
