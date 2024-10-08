package kjstyle.accommodation.domain.es;

import kjstyle.accommodation.domain.es.documents.AccommodationDoc;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationEsRepository extends ElasticsearchRepository<AccommodationDoc, String> {

    /**
     * 숙소명 일부일치 검색
     *   ㄴ DB로 따지면 name LIKE 검색
     * @param name
     * @return
     */
    @Query("{\"wildcard\": {\"name\": {\"value\": \"*?0*\"}}}")
    List<AccommodationDoc> findByNameLike(String name);
}