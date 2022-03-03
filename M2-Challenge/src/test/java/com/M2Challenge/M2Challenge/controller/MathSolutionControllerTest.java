package com.M2Challenge.M2Challenge.controller;

import com.M2Challenge.M2Challenge.models.MathSolution;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {}

    @Test
    public void shouldAddTwoNumbers() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(1);
        input.setOperand2(3);
        String inputString = mapper.writeValueAsString(input);

        MathSolution output = new MathSolution(1,3,"add",4);
        String outputString = mapper.writeValueAsString(output);

        mockMvc.perform(post("/add")
                .content(inputString)
                .contentType(MediaType.APPLICATION_JSON)
            )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputString));
    }

    @Test
    public void shouldReturn422ForAdd() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(1);
        String inputString = mapper.writeValueAsString(input);

        mockMvc.perform(post("/add")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldSubtractTwoNumbers() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(4);
        input.setOperand2(3);
        String inputString = mapper.writeValueAsString(input);

        MathSolution output = new MathSolution(4,3,"subtract",1);
        String outputString = mapper.writeValueAsString(output);

        mockMvc.perform(post("/subtract")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputString));
    }

    @Test
    public void shouldReturn422ForSubtract() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(5);
        String inputString = mapper.writeValueAsString(input);

        mockMvc.perform(post("/subtract")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldMultiplyTwoNumbers() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(5);
        input.setOperand2(3);
        String inputString = mapper.writeValueAsString(input);

        MathSolution output = new MathSolution(5,3,"multiply",15);
        String outputString = mapper.writeValueAsString(output);

        mockMvc.perform(post("/multiply")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputString));
    }

    @Test
    public void shouldReturn422ForMultiply() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(9);
        String inputString = mapper.writeValueAsString(input);

        mockMvc.perform(post("/multiply")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldDivideTwoNumbers() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(4);
        input.setOperand2(2);
        String inputString = mapper.writeValueAsString(input);

        MathSolution output = new MathSolution(4,2,"divide",2);
        String outputString = mapper.writeValueAsString(output);

        mockMvc.perform(post("/divide")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputString));
    }

    @Test
    public void shouldReturn422ForDivide() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(6);
        String inputString = mapper.writeValueAsString(input);

        mockMvc.perform(post("/divide")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturn422OperandAs0() throws Exception {
        MathSolution input = new MathSolution();
        input.setOperand1(4);
        input.setOperand2(0);
        String inputString = mapper.writeValueAsString(input);

        mockMvc.perform(post("/divide")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}