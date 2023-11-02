package hh.sof003.JavaDGMarketplace.Repository;

import org.springframework.data.repository.CrudRepository;
import hh.sof003.JavaDGMarketplace.Model.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
	Profile findById(int id);
}
