package app.components;

import java.util.List;

import app.entity.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.repositories.RequirementRepository;

@Component
public class RequirementComponent {
    @Autowired
    private RequirementRepository requirementRepo;

    public Requirement saveRequirement(RequirementDto dto)
    {
        Requirement r = new Requirement();
        r.setTitle(dto.getTitle());
        r.setInstruction(dto.getInstruction());
        r.setType(dto.getType());
        r.setDue_date(dto.getDue_date());
        return requirementRepo.save(r);
    }

    public String deleteRequirement(Long id)
    {
        try
		{
			requirementRepo.deleteById(id);
			return "Requirement with id: [" + id + "] deleted";
		}
		catch(Exception e)
		{
			return "Error deleting requirement";
		}
    }
	public List<Requirement> listRequirements()
    {
        return requirementRepo.findAll();
    }
    
    public List<Requirement> listRequirementsbySubject(String name)
    {
        //return List<Requirement>;
    }

}
