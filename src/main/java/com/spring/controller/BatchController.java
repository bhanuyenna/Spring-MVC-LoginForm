package com.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.BatchDAO;
import com.spring.dao.BatchDAOImpl;
import com.spring.model.Batch;
import com.spring.model.Person;

@Controller
public class BatchController {
	
	
	@RequestMapping(value = "/batch", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your batch Details");
		return "batch";
	}
	
	@SuppressWarnings("resource")
	@RequestMapping(value="/batchSave", method = RequestMethod.POST)
	public String saveBatch(Model model, @ModelAttribute("batch") Batch batch){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Batch currentBatch = new Batch();
		BatchDAO batchDAO= context.getBean(BatchDAO.class);
		currentBatch.setBatchId(batch.getBatchId());
		currentBatch.setProgram(batch.getProgram());
		currentBatch.setTrainerName(batch.getTrainerName());
		currentBatch.setStudentCount(batch.getStudentCount());
		currentBatch.setCourse(batch.getCourse());
		currentBatch.setCreatedDate((Date)batch.getCreatedDate());
		System.out.println((Date)batch.getCreatedDate());
		currentBatch.setUpdatedDate((Date)batch.getUpdatedDate());
		batchDAO.save(currentBatch);
		List<Batch> list = 	batchDAO.batchList();
		for (Batch p : list) {
			System.out.println("Person List::" + p);
		}
		model.addAttribute("msg", list); 
		
		context.close();
		
		return "batchsuccess";

	}
	
	@RequestMapping(value = "/updateBatch/{batchId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> updatePerson(@PathVariable("id") int id, @RequestBody Batch batch) {
		BatchDAOImpl b= new BatchDAOImpl();
		Batch updateBatch = b.getByBatchID(id);
		updateBatch.setCourse(batch.getCourse());
		updateBatch.setProgram(batch.getProgram());
		updateBatch.setStudentCount(batch.getStudentCount());
		updateBatch.setTrainerName(batch.getTrainerName());
		updateBatch.setCreatedDate(batch.getCreatedDate());
		updateBatch.setUpdatedDate(batch.getUpdatedDate());
		updateBatch.setBatchId(batch.getBatchId());
		b.updateBatch(updateBatch);
		
		return new ResponseEntity<Batch>(updateBatch, HttpStatus.OK);
	}

	@RequestMapping(value = "/removeBatch/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> deleteBatch(@PathVariable("id") int id) {
		BatchDAOImpl b= new BatchDAOImpl();
		Batch updateBatch = b.getByBatchID(id);
		b.deleteBatch(id);
		return new ResponseEntity<Batch>(updateBatch, HttpStatus.NO_CONTENT);

	}
	
}
