package sample.data.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BackEndInstanceRepository extends MongoRepository<BackEndInstance, String> {

    BackEndInstance findByUrl(String url);

}
