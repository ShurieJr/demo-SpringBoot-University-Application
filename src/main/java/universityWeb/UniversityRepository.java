package universityWeb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
    @Query(value="Select * from university where id =?1", nativeQuery = true)
    public List<University> search(@Param("keyword") Long id);
}
