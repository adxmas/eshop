package projects.adxmas.eshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.adxmas.eshop.entity.ItemObject;

public interface ItemRepository extends JpaRepository<ItemObject, Integer> {

}
