/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.Controller;

import com.BackendEcomerce.model.Feedback;
import com.BackendEcomerce.service.FeedbackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mota1
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping ("/api/")
public class FeedbackController {
    
      @Autowired
	public FeedbackService feedbackService;
	
        
        //Guardar
	@PostMapping("/feedback")
	public Feedback guardar (@RequestBody Feedback feedback){
		
		return feedbackService.save(feedback);                       	
	}
	
	//listar
	@GetMapping("/feedback")
	public List<Feedback> listar(){
		return feedbackService.findAll();
	}
	
	@DeleteMapping ("/feedback/{id}")
	public void eliminar(@PathVariable Integer id){
		feedbackService.delete(id);
	}
	
        //get una cuenta
	@GetMapping ("/feedback/{id}")
	public Feedback getUnaAhorros(@PathVariable Integer id){
		return feedbackService.findById(id);
	}
	
        @PutMapping ("/feedback/{id}")
	public Feedback modificar (@RequestBody Feedback feedback, @PathVariable Integer id){
		
                Feedback Actual = feedbackService.findById(id);
                Actual.setDescripcion(feedback.getDescripcion());
   
                return feedbackService.save(Actual);
	}
    
}
