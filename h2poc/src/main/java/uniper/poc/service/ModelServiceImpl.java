package uniper.poc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniper.poc.exception.ResourceNotFoundException;
import uniper.poc.model.ModelPojo;
import uniper.poc.model.Models;
import uniper.poc.repository.ModelRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ModelServiceImpl implements ModelService{
    @Autowired
    private ModelRepository modelRepository;

    @Override
    public ModelPojo createModel(ModelPojo modelPojo) {
        return modelRepository.save(modelPojo);
    }

    @Override
    public ModelPojo updateModel(ModelPojo modelPojo) {
        log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("Updated data comming is "+modelPojo);
        return modelRepository.save(modelPojo);
    }

    @Override
    public Models getAllModels() {
        List<ModelPojo> modelPojos = modelRepository.findAll();
        return new Models(modelPojos);
    }

    @Override
    public ModelPojo getModelById(long modelId) {
        Optional<ModelPojo> modelPojoOptionalDB = modelRepository.findById(modelId);
        if (modelPojoOptionalDB.isPresent()){
            return modelPojoOptionalDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : "+modelId);
        }
    }

    @Override
    public void deleteModel(long id) {
        Optional<ModelPojo> modelPojoOptionalDB = modelRepository.findById(id);
        if (modelPojoOptionalDB.isPresent()){
            modelRepository.delete(modelPojoOptionalDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : "+id);
        }
    }

}
