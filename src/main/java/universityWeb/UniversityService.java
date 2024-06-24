package universityWeb;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UniversityService {
    private final UniversityRepository repo;

    public UniversityService(UniversityRepository repo) {
        this.repo = repo;
    }

    public void insertUniversity(University university){
        repo.save(university);
    }
    public void updateUniversity(University university){
        repo.save(university);
    }
    public void deleteUniversity(Long id){
        repo.deleteById(id);
    }
    public University getUniversityById(Long id){
       return repo.findById(id).orElse(null);
    }
    public List<University> getAllUniversity(Long keyword){
        if(keyword != null)
            return repo.search(keyword);
        return repo.findAll();
    }
}
