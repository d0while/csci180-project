package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Grades;
import app.repositories.GradesRepository;

@Component
public class GradesComponent {

    @Autowired
    private GradesRepository gradeRepo;

    public Grades saveGrades(GradesDto dto)
    {
        Grades g = new Grades();
        g.setTitle(dto.getTitle());
        g.setGrade(dto.getGrade());
        return gradeRepo.save(g);

    }
    public String deleteGrades(Long id) {
		try
		{
			gradeRepo.deleteById(id);
			return "Grade with id: [" + id + "] deleted";
		}
		catch(Exception e)
		{
			return "Error deleting Grade";
		}
	}
   
    public List<Grades> listTeachers() {
		return gradeRepo.findAll();
	}

	//qpiCalculator: displays computed qpi based on the submitted grades. May also take a subject argument to only calculate qpi for the given subject.

    
}
