package com.crud.springboot.springBootRestH2;

import java.util.ArrayList;
import java.util.List;

import com.crud.springboot.springBootRestH2.model.User;
import com.crud.springboot.springBootRestH2.service.UserService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ExtendWith(SpringExtension.class)
@WebMvcTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService employeeService;

    @Test
    public void testGetDepartment() throws Exception {
        User employee = new User();
        employee.setId(1);

        List<User> employeeList = new ArrayList<>();
        employeeList.add(employee);

        given(employeeService.findAll()).willReturn(employeeList);

        this.mockMvc.perform(get("/user")).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1));
    }

}