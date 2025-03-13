package com.example.megacitycabbackend.controller;

import static org.mockito.Mockito.when;

import com.example.megacitycabbackend.dto.LoginDto;
import com.example.megacitycabbackend.dto.UserDTO;
import com.example.megacitycabbackend.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    /**
     * Test {@link UserController#testMapping()}.
     * <p>
     * Method under test: {@link UserController#testMapping()}
     */
    @Test
    @DisplayName("Test testMapping()")
    @Tag("MaintainedByDiffblue")
    void testTestMapping() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/test");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    /**
     * Test {@link UserController#saveUser(UserDTO)}.
     * <p>
     * Method under test: {@link UserController#saveUser(UserDTO)}
     */
    @Test
    @DisplayName("Test saveUser(UserDTO)")
    @Tag("MaintainedByDiffblue")
    void testSaveUser() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(userService.saveUser(Mockito.<UserDTO>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));

        UserDTO userDTO = new UserDTO();
        userDTO.setAddress("42 Main St");
        userDTO.setEmail("jane.doe@example.org");
        userDTO.setGender("Gender");
        userDTO.setId("42");
        userDTO.setName("Name");
        userDTO.setNic("Nic");
        userDTO.setPassword("iloveyou");
        userDTO.setRole("Role");
        userDTO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(userDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test {@link UserController#getAllUsers()}.
     * <p>
     * Method under test: {@link UserController#getAllUsers()}
     */
    @Test
    @DisplayName("Test getAllUsers()")
    @Tag("MaintainedByDiffblue")
    void testGetAllUsers() throws Exception {
        // Arrange
        when(userService.getAllUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/users");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Test {@link UserController#login(LoginDto)}.
     * <p>
     * Method under test: {@link UserController#login(LoginDto)}
     */
    @Test
    @DisplayName("Test login(LoginDto)")
    @Tag("MaintainedByDiffblue")
    void testLogin() throws Exception {
        // Arrange
        when(userService.login(Mockito.<LoginDto>any())).thenReturn("Login");

        LoginDto loginDto = new LoginDto();
        loginDto.setPassword("iloveyou");
        loginDto.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(loginDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/auth")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Login"));
    }

    /**
     * Test {@link UserController#updateUser(UserDTO)}.
     * <p>
     * Method under test: {@link UserController#updateUser(UserDTO)}
     */
    @Test
    @DisplayName("Test updateUser(UserDTO)")
    @Tag("MaintainedByDiffblue")
    void testUpdateUser() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(userService.updateUser(Mockito.<UserDTO>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));

        UserDTO userDTO = new UserDTO();
        userDTO.setAddress("42 Main St");
        userDTO.setEmail("jane.doe@example.org");
        userDTO.setGender("Gender");
        userDTO.setId("42");
        userDTO.setName("Name");
        userDTO.setNic("Nic");
        userDTO.setPassword("iloveyou");
        userDTO.setRole("Role");
        userDTO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(userDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test {@link UserController#deleteUser(UserDTO)}.
     * <p>
     * Method under test: {@link UserController#deleteUser(UserDTO)}
     */
    @Test
    @DisplayName("Test deleteUser(UserDTO)")
    @Tag("MaintainedByDiffblue")
    void testDeleteUser() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(userService.deleteUser(Mockito.<UserDTO>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));

        UserDTO userDTO = new UserDTO();
        userDTO.setAddress("42 Main St");
        userDTO.setEmail("jane.doe@example.org");
        userDTO.setGender("Gender");
        userDTO.setId("42");
        userDTO.setName("Name");
        userDTO.setNic("Nic");
        userDTO.setPassword("iloveyou");
        userDTO.setRole("Role");
        userDTO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(userDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test {@link UserController#getUser(String)}.
     * <p>
     * Method under test: {@link UserController#getUser(String)}
     */
    @Test
    @DisplayName("Test getUser(String)")
    @Tag("MaintainedByDiffblue")
    void testGetUser() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(userService.getUser(Mockito.<String>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/user/{id}", "42");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
