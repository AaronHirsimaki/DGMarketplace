package hh.sof003.JavaDGMarketplace.Repository;

import org.springframework.data.repository.CrudRepository;

import hh.sof003.JavaDGMarketplace.Model.Disc;

public interface DiscRepository extends CrudRepository<Disc, Integer>{
	Disc findById(int id);
}
