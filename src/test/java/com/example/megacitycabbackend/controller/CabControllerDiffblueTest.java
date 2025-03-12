package com.example.megacitycabbackend.controller;

import static org.mockito.Mockito.when;

import com.example.megacitycabbackend.dto.CabUpdateDto;
import com.example.megacitycabbackend.service.CabService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Disabled;
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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CabController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class CabControllerDiffblueTest {
    @Autowired
    private CabController cabController;

    @MockBean
    private CabService cabService;

    /**
     * Test {@link CabController#addCabs(String, String, String, String, String, String, String, int, double, double, MultipartFile)}.
     * <ul>
     *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
     * </ul>
     * <p>
     * Method under test: {@link CabController#addCabs(String, String, String, String, String, String, String, int, double, double, MultipartFile)}
     */
    @Test
    @DisplayName("Test addCabs(String, String, String, String, String, String, String, int, double, double, MultipartFile); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testAddCabs_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        CabController cabController = new CabController();

        // Act
        cabController.addCabs("Name", "The characteristics of someone or something", "Driverid", "Driverlicence", "Status",
                "Cab Owner Name", "6625550144", 3, 10.0d, 10.0d,
                new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    }

    /**
     * Test {@link CabController#getCabs()}.
     * <p>
     * Method under test: {@link CabController#getCabs()}
     */
    @Test
    @DisplayName("Test getCabs()")
    @Tag("MaintainedByDiffblue")
    void testGetCabs() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(cabService.getAvalibleCabs())
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/cabs");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(cabController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test {@link CabController#getCab(String)}.
     * <p>
     * Method under test: {@link CabController#getCab(String)}
     */
    @Test
    @DisplayName("Test getCab(String)")
    @Tag("MaintainedByDiffblue")
    void testGetCab() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(cabService.getCab(Mockito.<String>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/cab/{id}", "42");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(cabController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test {@link CabController#getAllCabs()}.
     * <p>
     * Method under test: {@link CabController#getAllCabs()}
     */
    @Test
    @DisplayName("Test getAllCabs()")
    @Tag("MaintainedByDiffblue")
    void testGetAllCabs() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(cabService.getAllCabs())
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/cab/all");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(cabController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test {@link CabController#updateCabDetails(CabUpdateDto)}.
     * <p>
     * Method under test: {@link CabController#updateCabDetails(CabUpdateDto)}
     */
    @Test
    @DisplayName("Test updateCabDetails(CabUpdateDto)")
    @Tag("MaintainedByDiffblue")
    void testUpdateCabDetails() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(cabService.updateCab(Mockito.<CabUpdateDto>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));

        CabUpdateDto cabUpdateDto = new CabUpdateDto();
        cabUpdateDto.setAddedDate("2020-03-01");
        cabUpdateDto.setAvarageKmPrice(10.0d);
        cabUpdateDto.setCabDescription("Cab Description");
        cabUpdateDto.setCabName("Cab Name");
        cabUpdateDto.setDriverLicence("Driver Licence");
        cabUpdateDto.setFirst7kmPrice(10.0d);
        cabUpdateDto.setId("42");
        cabUpdateDto.setOwnerName("Owner Name");
        cabUpdateDto.setPhoneNumber("6625550144");
        cabUpdateDto.setSheetCount(3);
        cabUpdateDto.setStatus("Status");
        String content = (new ObjectMapper()).writeValueAsString(cabUpdateDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/api/v1/cab")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(cabController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test {@link CabController#getDriverCabs(String)}.
     * <p>
     * Method under test: {@link CabController#getDriverCabs(String)}
     */
    @Test
    @DisplayName("Test getDriverCabs(String)")
    @Tag("MaintainedByDiffblue")
    void testGetDriverCabs() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(cabService.getCabsByDriverId(Mockito.<String>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/cab/dirver/{id}", "42");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(cabController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test {@link CabController#deleteCab(String)}.
     * <p>
     * Method under test: {@link CabController#deleteCab(String)}
     */
    @Test
    @DisplayName("Test deleteCab(String)")
    @Tag("MaintainedByDiffblue")
    void testDeleteCab() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(cabService.deleteCab(Mockito.<String>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/cab/{id}", "42");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(cabController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
