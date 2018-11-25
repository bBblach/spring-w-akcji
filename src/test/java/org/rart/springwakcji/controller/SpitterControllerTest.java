package org.rart.springwakcji.controller;

import org.junit.Test;
import org.mockito.Mockito;
import org.rart.springwakcji.entity.Spitter;
import org.rart.springwakcji.repository.SpitterRepository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class SpitterControllerTest {


    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockedRepository = Mockito.mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("jbauer", "24Hours", "Jack", "Bauer");
        Spitter saved = new Spitter(24L, "jbauer", "24Hours", "Jack", "Bauer");
        when(mockedRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(mockedRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("login", "jbauer")
                .param("password", "24Hours"))
                .andExpect(redirectedUrl("/spitter/jbauer"));


        verify(mockedRepository, atLeastOnce()).save(unsaved);

    }

    /* test GET /spittler/register */
    @Test
    public void testGetRegisterForm() throws Exception {
        SpitterRepository mockedRepository = Mockito.mock(SpitterRepository.class);

        SpitterController controller = new SpitterController(mockedRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("register-page"));

    }
}