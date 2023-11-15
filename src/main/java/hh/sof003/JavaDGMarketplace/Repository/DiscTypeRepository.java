package hh.sof003.JavaDGMarketplace.Repository;

import org.springframework.data.repository.CrudRepository;

import hh.sof003.JavaDGMarketplace.Model.DiscType;

public interface DiscTypeRepository extends CrudRepository<DiscType, Integer>{
	DiscType findById(int id);
}
