package hh.sof003.JavaDGMarketplace.Repository;

import org.springframework.data.repository.CrudRepository;

import hh.sof003.JavaDGMarketplace.Model.Bag;

public interface BagRepository extends CrudRepository<Bag, Integer>{
	Bag findById(int id);
}
