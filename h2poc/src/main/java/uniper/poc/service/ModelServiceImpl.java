package uniper.poc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniper.poc.exception.ResourceNotFoundException;
import uniper.poc.model.Login;
import uniper.poc.model.ModelPojo;
import uniper.poc.model.Models;
import uniper.poc.repository.ModelRepository;

import java.sql.SQLException;
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

    public boolean verifyLogin(Login login) throws SQLException {
        boolean status =false;
        if (login.getMobileNumber()==null || login.getPassword().isEmpty()) {
            return status;
        } else {
            log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++"+login);
            Optional<ModelPojo> optionalModelPojo = modelRepository.findById(login.getMobileNumber());
            ModelPojo modelPojo = null;
            if(optionalModelPojo.isPresent()){
                modelPojo = optionalModelPojo.get();
                if(modelPojo.getPassword().equalsIgnoreCase(login.getPassword())){
                    status=true;
                }
            }
            return status;
        }
    }

    public boolean isRegistered(ModelPojo user) throws SQLException {
        if (user.getMobileNumber()==null|| user.getPassword().isEmpty() || user.getFirstName().isEmpty()
                || user.getEmail().isEmpty()) {
            return false;
        } else {
            log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++");
            modelRepository.save(user);
            log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++Saved successfully");
            return true;
        }
    }

}
