package kony.insta;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import kony.insta.dto.account.*;
import kony.insta.dto.execptions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class InstaCloneApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    registerDTO validUser = registerDTO.builder()
            .age(24)
            .email("konykony22@gmail.com")
            .username("Nginx")
            .password("mypassword")
            .gender("male")
            .build();


    @DisplayName("New user POST /account")
    @Order(1)
    @Nested
    class testNewUser{
        @Test
        @DisplayName("has registered successfully")
        @Order(1)
        void t1() throws Exception {
            registerDTO user = registerDTO.builder()
                    .age(24)
                    .email("konykony22@gmail.com")
                    .username("Nginx")
                    .password("mypassword")
                    .gender("male")
                    .build();

            var req = mockMvc.perform(post("/account")
                            .contentType("application/json")
                            .content(mapper.writeValueAsString(user)))
                    .andExpect(status().isOk())
                    .andReturn();

            registerDTOres res = mapper.readValue(req.getResponse().getContentAsString(), registerDTOres.class);
            assertEquals(res.id, 1);
        }

        @Test
        @DisplayName("can't have already taken username")
        @Order(2)
        void t3() throws Exception {
            registerDTO user = registerDTO.builder()
                    .age(24)
                    .email("konykony22@gmail.com")
                    .username("Nginx")
                    .password("mypassword")
                    .gender("male")
                    .build();

            var req = mockMvc.perform(post("/account")
                            .contentType("application/json")
                            .content(mapper.writeValueAsString(user)))
                    .andExpect(status().isBadRequest())
                    .andReturn();
        }
        @Test
        @DisplayName("can't have age <16 ")
        void t2() throws Exception {
            registerDTO user = registerDTO.builder()
                    .age(12)
                    .email("konykony22@gmail.com")
                    .username("user55")
                    .password("mypassword")
                    .gender("male")
                    .build();

            var req = mockMvc.perform(post("/account")
                            .contentType("application/json")
                            .content(mapper.writeValueAsString(user)))
                    .andExpect(status().isBadRequest())
                    .andReturn();
        }
        @Test
        @DisplayName("gender must be male or female")
        void t4() throws Exception {
            registerDTO user = registerDTO.builder()
                    .age(24)
                    .email("konykony221@gmail.com")
                    .username("fakename2")
                    .password("mypassword")
                    .gender("boy")
                    .build();

            var req = mockMvc.perform(post("/account")
                            .contentType("application/json")
                            .content(mapper.writeValueAsString(user)))
                    .andExpect(status().isBadRequest())
                    .andReturn();
        }
    }

    @Order(2)
    @Nested
    @DisplayName("GET /account/{username}")
    class gets{
    @DisplayName("gets existing user")
    @Test
    void t1()throws Exception {
        var req = mockMvc.perform(get("/account/"+ validUser.getUsername()))
                .andExpect(status().isOk())
                .andReturn();
        getUserDTO res = mapper.readValue(req.getResponse().getContentAsString(), getUserDTO.class);
        assertEquals(res.getAge(), validUser.getAge());
        assertEquals(res.getEmail(), validUser.getEmail());
    }
    @Test
    @DisplayName("non existing user returns 404 NotFound")
    void t2()throws Exception {
        var req = mockMvc.perform(get("/account/"+"NONEXISTINGUSER"))
                .andExpect(status().isNotFound())
                .andReturn();
        var res = mapper.readValue(req.getResponse().getContentAsString(), errorMessageDTO.class);
    }
    }
}
