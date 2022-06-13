package uniper.poc.service;

import uniper.poc.model.ModelPojo;
import uniper.poc.model.Models;

public interface ModelService {
    ModelPojo createModel(ModelPojo modelPojo);

    ModelPojo updateModel(ModelPojo modelPojo);

    Models getAllModels();

    ModelPojo getModelById(long modelId);

    void deleteModel(long id);
}
