package br.com.exercicios.ilab.ecommerce.mysql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioAPITests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnListaDeUsuarios() throws Exception{
		System.out.println("To no test da API");
		mockMvc.perform(MockMvcRequestBuilders.get("/usuarios"))
			   .andExpect(MockMvcResultMatchers.status().isOk())
			   //.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
			   .andDo(MockMvcResultHandlers.print());		
	}
	
	@Test
	public void shouldExistEndpoint() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/1"))
			   .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void shouldReturnUsuarioValido() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/1"))
		       .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void shouldReturnNotFoundStatus() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/100"))
		       .andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	@Test
	public void shouldReturnBadRequestStatus() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/-1"))
		       .andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
