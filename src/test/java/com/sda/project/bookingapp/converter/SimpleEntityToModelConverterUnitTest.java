package com.sda.project.bookingapp.converter;

import com.sda.project.bookingapp.entity.NewsletterEntity;
import com.sda.project.bookingapp.model.NewsletterModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleEntityToModelConverterUnitTest {

    private SimpleEntityToModelConverter simpleEntityToModelConverter;

    @Before
    public void setup(){
        simpleEntityToModelConverter = new SimpleEntityToModelConverter();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void shouldConvertNewsletterEntityToNewsletterModel(){
        //given
        NewsletterEntity newsletterEntity = NewsletterEntity.builder().id(1L).email("some@home.com").build();

        //when
        NewsletterModel actualNewsletterModel = simpleEntityToModelConverter.newsletterEntityToModel(newsletterEntity);


        //then
        Assert.assertEquals("some@home.com", actualNewsletterModel.getEmail());
        Assert.assertEquals(1L, actualNewsletterModel.getId());
    }

    @Test
    public void shouldThrowExceptionWhenNewsletterEntityIsEmpty(){
        //given


        //when


        //then
    }
}
