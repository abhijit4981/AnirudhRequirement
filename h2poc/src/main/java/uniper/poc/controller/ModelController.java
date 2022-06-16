package uniper.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniper.poc.model.ModelPojo;
import uniper.poc.model.Models;
import uniper.poc.service.ModelService;

@RestController
@RequestMapping("/models")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @GetMapping
    public Models getAllModels() {
        return modelService.getAllModels();
    }

    @GetMapping("/{id}")
    public ModelPojo getModelById(@PathVariable long id) {
        return modelService.getModelById(id);
    }

    @PostMapping
    public ModelPojo createModel(@RequestBody ModelPojo modelPojo) {
        return modelService.createModel(modelPojo);
    }
    @GetMapping("/dummy")
    public ModelPojo createDummyModel() {
        ModelPojo modelPojo = new ModelPojo();
        modelPojo.setFirstName("Abhijit");
        modelPojo.setLastName("Mishra");
        modelPojo.setEmail("2087498@cognizant.com");
        modelPojo.setMobileNumber(9003049525L);
        modelPojo.setPassword("Admin#123");
        return modelService.createModel(modelPojo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelPojo> updateModel(@PathVariable long id, @RequestBody ModelPojo modelPojo) {
        modelPojo.setMobileNumber(id);
        return ResponseEntity.ok().body(modelService.updateModel(modelPojo));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteModel(@PathVariable long id) {
        modelService.deleteModel(id);
        return HttpStatus.OK;
    }
}
