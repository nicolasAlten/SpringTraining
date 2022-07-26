package com.spring.springTraining.Controller;

import com.spring.springTraining.Entity.UserEntity;
import com.spring.springTraining.Service.Interfaces.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
//@DataJPATest
public class UserController {
    @InjectMocks
    UserService userService;

    @Mock
    UserEntity user;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void userTestGetController() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/getUserById/{1}")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    public void userTestPostController() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/postUser")
                .content(String.valueOf(user))
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) content().json(String.valueOf(user)));
    }

    @Test
    public void userTestGetControllerAssert() throws Exception {
        // given
        when(userService.getUserById(1))
                .thenReturn(user);

        RequestBuilder request = MockMvcRequestBuilders
                .get("/getUserById/{1}")
                .accept(MediaType.APPLICATION_JSON);

        // when
        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn().getResponse();

        // then
        assertEquals(response.getStatus(), HttpStatus.OK.value());
        assertEquals(response.getContentAsString(), userService.getUserById(1).toString());
    }

    @Test
    public void userTestGetControllerAssertNotFound() throws Exception {
        // given
        doThrow(new ArithmeticException("Something went wrong"))
                .when(userService.getUserById(1));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/getUserById/{1}")
                .accept(MediaType.APPLICATION_JSON);

        // when
        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn().getResponse();

        // then
        assertEquals(response.getStatus(), HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void headerIsPresent() throws Exception {
        // given
        when(userService.getUserById(1))
                .thenReturn(user);

        RequestBuilder request = MockMvcRequestBuilders
                .get("/getUserById/{1}")
                .accept(MediaType.APPLICATION_JSON);

        // when
        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn().getResponse();

        // then
        assertEquals(response.getStatus(), HttpStatus.NOT_FOUND.value());
        assertTrue(response.getHeaders("MENU-APP").contains("login"));
    }

}
