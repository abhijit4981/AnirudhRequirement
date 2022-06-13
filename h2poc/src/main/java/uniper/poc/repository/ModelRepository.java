package uniper.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniper.poc.model.ModelPojo;
@Repository
public interface ModelRepository extends JpaRepository<ModelPojo,Long> {
}
