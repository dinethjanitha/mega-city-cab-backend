package com.example.megacitycabbackend.controller;

import static org.mockito.Mockito.when;

import com.example.megacitycabbackend.dto.BookingBillingDto;
import com.example.megacitycabbackend.dto.BookingDtoUsers;
import com.example.megacitycabbackend.dto.BookingStatusUpdateDto;
import com.example.megacitycabbackend.model.Booking;
import com.example.megacitycabbackend.service.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@ContextConfiguration(classes = {BookingController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class BookingControllerTest {
    @Autowired
    private BookingController bookingController;

    @MockBean
    private BookingService bookingService;


    @Test
    @DisplayName("Test saveBooking(Booking); when Booking (default constructor) UserId is " +
            "empty string; then status four hundred")
    @Tag("MaintainedByDiffblue")
    void testSaveBooking_whenBookingUserIdIsEmptyString_thenStatusFourHundred() throws Exception {

        Mockito.<ResponseEntity<?>>when(bookingService.makeBooking(Mockito.<Booking>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));

        Booking booking = new Booking();
        booking.setBookingDate("2020-03-01");
        booking.setBookingStatus("Booking Status");
        booking.setBookingTime("Booking Time");
        booking.setCabId("42");
        booking.setDate("2020-03-01");
        booking.setDriverId("42");
        booking.setEndDestination("End Destination");
        booking.setId("42");
        booking.setNote("Note");
        booking.setStartDestination("Start Destination");
        booking.setTotal(10.0d);
        booking.setTotalKM(10.0d);
        booking.setUserId("");
        String content = (new ObjectMapper()).writeValueAsString(booking);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/booking")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);


        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Required field not found!"));
    }

    /**
     * Test {@link BookingController#saveBooking(Booking)}.
     * <ul>
     *   <li>When {@link Booking} (default constructor) DriverId is empty string.</li>
     *   <li>Then status four hundred.</li>
     * </ul>
     * <p>
     * Method under test: {@link BookingController#saveBooking(Booking)}
     */
    @Test
    @DisplayName("Test saveBooking(Booking); when Booking (default constructor) DriverId is empty string; then status four hundred")
    @Tag("MaintainedByDiffblue")
    void testSaveBooking_whenBookingDriverIdIsEmptyString_thenStatusFourHundred() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(bookingService.makeBooking(Mockito.<Booking>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));

        Booking booking = new Booking();
        booking.setBookingDate("2020-03-01");
        booking.setBookingStatus("Booking Status");
        booking.setBookingTime("Booking Time");
        booking.setCabId("42");
        booking.setDate("2020-03-01");
        booking.setDriverId("");
        booking.setEndDestination("End Destination");
        booking.setId("42");
        booking.setNote("Note");
        booking.setStartDestination("Start Destination");
        booking.setTotal(10.0d);
        booking.setTotalKM(10.0d);
        booking.setUserId("42");
        String content = (new ObjectMapper()).writeValueAsString(booking);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/booking")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Required field not found!"));
    }

    /**
     * Test {@link BookingController#saveBooking(Booking)}.
     * <ul>
     *   <li>When {@link Booking} (default constructor) DriverId is {@code 42}.</li>
     *   <li>Then status {@link StatusResultMatchers#isOk()}.</li>
     * </ul>
     * <p>
     * Method under test: {@link BookingController#saveBooking(Booking)}
     */
    @Test
    @DisplayName("Test saveBooking(Booking); when Booking (default constructor) DriverId is '42'; then status isOk()")
    @Tag("MaintainedByDiffblue")
    void testSaveBooking_whenBookingDriverIdIs42_thenStatusIsOk() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(bookingService.makeBooking(Mockito.<Booking>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));

        Booking booking = new Booking();
        booking.setBookingDate("2020-03-01");
        booking.setBookingStatus("Booking Status");
        booking.setBookingTime("Booking Time");
        booking.setCabId("42");
        booking.setDate("2020-03-01");
        booking.setDriverId("42");
        booking.setEndDestination("End Destination");
        booking.setId("42");
        booking.setNote("Note");
        booking.setStartDestination("Start Destination");
        booking.setTotal(10.0d);
        booking.setTotalKM(10.0d);
        booking.setUserId("42");
        String content = (new ObjectMapper()).writeValueAsString(booking);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/booking")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test {@link BookingController#getDriverBookings(String)}.
     * <p>
     * Method under test: {@link BookingController#getDriverBookings(String)}
     */
    @Test
    @DisplayName("Test getDriverBookings(String)")
    @Tag("MaintainedByDiffblue")
    void testGetDriverBookings() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(bookingService.getDriverBookings(Mockito.<String>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/bookings/driver/{id}", "42");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test {@link BookingController#updateBooking(BookingStatusUpdateDto)}.
     * <p>
     * Method under test: {@link BookingController#updateBooking(BookingStatusUpdateDto)}
     */
    @Test
    @DisplayName("Test updateBooking(BookingStatusUpdateDto)")
    @Tag("MaintainedByDiffblue")
    void testUpdateBooking() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(bookingService.updateBooking(Mockito.<BookingStatusUpdateDto>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));

        BookingStatusUpdateDto bookingStatusUpdateDto = new BookingStatusUpdateDto();
        bookingStatusUpdateDto.setBookingStatus("Booking Status");
        bookingStatusUpdateDto.setId("42");
        String content = (new ObjectMapper()).writeValueAsString(bookingStatusUpdateDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/api/v1/booking")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test {@link BookingController#getUserBookings(String)}.
     * <p>
     * Method under test: {@link BookingController#getUserBookings(String)}
     */
    @Test
    @DisplayName("Test getUserBookings(String)")
    @Tag("MaintainedByDiffblue")
    void testGetUserBookings() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(bookingService.getUserBookings(Mockito.<String>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/booking/user/{id}", "42");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test {@link BookingController#deleteBooking(String)}.
     * <p>
     * Method under test: {@link BookingController#deleteBooking(String)}
     */
    @Test
    @DisplayName("Test deleteBooking(String)")
    @Tag("MaintainedByDiffblue")
    void testDeleteBooking() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(bookingService.deleteBooking(Mockito.<String>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/booking/{id}", "42");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test {@link BookingController#updateUserBooking(BookingDtoUsers)}.
     * <p>
     * Method under test: {@link BookingController#updateUserBooking(BookingDtoUsers)}
     */
    @Test
    @DisplayName("Test updateUserBooking(BookingDtoUsers)")
    @Tag("MaintainedByDiffblue")
    void testUpdateUserBooking() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(bookingService.updateBookingForUsers(Mockito.<BookingDtoUsers>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));

        BookingDtoUsers bookingDtoUsers = new BookingDtoUsers();
        bookingDtoUsers.setBookingDate("2020-03-01");
        bookingDtoUsers.setBookingTime("Booking Time");
        bookingDtoUsers.setDate("2020-03-01");
        bookingDtoUsers.setEndDestination("End Destination");
        bookingDtoUsers.setId("42");
        bookingDtoUsers.setNote("Note");
        bookingDtoUsers.setStartDestination("Start Destination");
        String content = (new ObjectMapper()).writeValueAsString(bookingDtoUsers);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/api/v1/booking/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test {@link BookingController#updateBookingBill(BookingBillingDto)}.
     * <p>
     * Method under test: {@link BookingController#updateBookingBill(BookingBillingDto)}
     */
    @Test
    @DisplayName("Test updateBookingBill(BookingBillingDto)")
    @Tag("MaintainedByDiffblue")
    void testUpdateBookingBill() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(bookingService.updateBillingDetails(Mockito.<BookingBillingDto>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));

        BookingBillingDto bookingBillingDto = new BookingBillingDto();
        bookingBillingDto.setBookingStatus("Booking Status");
        bookingBillingDto.setId("42");
        bookingBillingDto.setTotal(10.0d);
        bookingBillingDto.setTotalKM(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(bookingBillingDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/api/v1/booking/bill")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test {@link BookingController#getTodayBookingCount()}.
     * <p>
     * Method under test: {@link BookingController#getTodayBookingCount()}
     */
    @Test
    @DisplayName("Test getTodayBookingCount()")
    @Tag("MaintainedByDiffblue")
    void testGetTodayBookingCount() throws Exception {
        // Arrange
        when(bookingService.getTodayBookingCount()).thenReturn(3L);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/bookings/today/count");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("3"));
    }

    /**
     * Test {@link BookingController#getBooking(String)}.
     * <p>
     * Method under test: {@link BookingController#getBooking(String)}
     */
    @Test
    @DisplayName("Test getBooking(String)")
    @Tag("MaintainedByDiffblue")
    void testGetBooking() throws Exception {
        // Arrange
        Mockito.<ResponseEntity<?>>when(bookingService.getOneBooking(Mockito.<String>any()))
                .thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(200)));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/booking/{id}", "42");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(bookingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
