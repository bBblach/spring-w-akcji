package org.rart.springwakcji.controller;

import org.junit.Test;
import org.mockito.Mockito;
import org.rart.springwakcji.entity.Spittle;
import org.rart.springwakcji.repository.SpittleNoDataBaseRpository;
import org.rart.springwakcji.repository.SpittleRepository;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class SpittleControllerTest {


    /* Test kontrolera opartego o ścieżkę */
    @Test
    public void pathControllerTest() throws Exception {
        Spittle expectedSpittle = new Spittle("hello everyone " ,  LocalDateTime.now());
        SpittleRepository mockRepository  = mock(SpittleRepository.class);
        when(mockRepository.findOne(12345L)).thenReturn(expectedSpittle);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/spittles/12345"))
                .andExpect(view().name("single-spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));
    }



    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectedSpittles = createList(50);
        SpittleRepository mockRepo = Mockito.mock(SpittleRepository.class);
        when(mockRepo.findSpittles(Long.MAX_VALUE, 50)).thenReturn(expectedSpittles);
        SpittleController controller = new SpittleController(mockRepo);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        String uri = "/spittles?max=8&count=50";
        mockMvc.perform(get(uri))
                .andExpect(view().name("spittles-page"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }
    @Test
    public void shouldShowRecentSpittles() throws Exception{
        List<Spittle> expectedSpittles = createList(20);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);
        SpittleController spittleController = new SpittleController(mockRepository);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spittleController)
                .build();
        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles-page"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }


    private List<Spittle> createList(int count){
        List<Spittle> spittles = new ArrayList<>(count);
        for (int i =0; i<count; i++){
            Spittle spittle = new Spittle(("Spittle no=" + (i+1)) , LocalDateTime.now());
            spittles.add(spittle);
        }
        return spittles;
    }



}
