package com.sda.project.bookingapp.service;

import com.sda.project.bookingapp.model.TopDestinationModel;
import com.sda.project.bookingapp.repository.AddressRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


public class AddressServiceUntTest {

    private AddressService addressService = null;
    private AddressRepository addressRepository = Mockito.mock(AddressRepository.class);
    List<TopDestinationModel> topDestinationModels = new ArrayList<>();

    @Before
    public void setup(){
        for (int i = 0; i < 10; i++) {
            TopDestinationModel topDestinationModel = new TopDestinationModel();
            topDestinationModel.setAmount(i);
            topDestinationModel.setCity("City " + 1);
            topDestinationModel.setCountry("Countre" + 1);
            topDestinationModels.add(topDestinationModel);
        }
        addressService = new AddressService(addressRepository);
    }

    @Test
    public void shouldHaveTopDestinations(){
        //given
        Mockito.when(addressRepository.findTopDestinations()).thenReturn(topDestinationModels);

        //when
        List<TopDestinationModel> topDestinationModels = addressService.getTopDestinations();

        //then
        Assert.assertNotNull(topDestinationModels);
    }

    @Test
    public void shouldHave8TopDestinations(){
        //given
        int expectedSize = 8;
        Mockito.when(addressRepository.findTopDestinations()).thenReturn(topDestinationModels);

        //when
        List<TopDestinationModel> topDestinationModels = addressService.getTopDestinations();

        //then
        Assert.assertNotNull(topDestinationModels);
        Assert.assertEquals(expectedSize, topDestinationModels.size());
    }

    @Test
    public void shouldBringTopDestinationsFromRepository() {
        // we check that method was called and logic was not changed.

        // given, when
        addressService.getTopDestinations();

        //then
        Mockito.verify(addressRepository).findTopDestinations();
    }
}
