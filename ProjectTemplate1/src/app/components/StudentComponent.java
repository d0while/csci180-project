package app.components;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import app.entity.Student;
import app.entity.UploadedFile;
import app.repositories.StudentRepository;
import app.repositories.UploadedFileRepository;

@Component
public class StudentComponent {
	
	
	@Autowired
	private StudentRepository studentRepo;
	
	public Student saveStudent(String name, String email) {
		Student s = new Student();
		s.setName(name);
		s.setEmail(email);
	
		return studentRepo.save(s);
	}
	
	
	public String deleteStudent(Long id) {
		studentRepo.deleteById(id);
		return "Student with id: [" + id + "] deleted";
	}
	
	public List<Student> listStudents() {
		return studentRepo.findAll();
	}
	
	public Student findById(Long id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	public List<Student> findByName(String nameQuery) {
		return studentRepo.findByName(nameQuery);
	
	}
	
	@Autowired
	UploadedFileRepository repo;
	String UPLOAD_PATH = "temp/";
	
	public List<UploadedFile> getFiles()
	{
		return repo.findAll();
	}
	
	
	public String saveFile(InputStream uploadedInputStream, String filename, long id)
	{
	    try
	    {
	    	File dir = new File(UPLOAD_PATH);
	    	dir.mkdirs();
	    	
	        int read = 0;
	        byte[] bytes = new byte[1024];
	 
	        File file = new File(dir, filename);
	        
			OutputStream out = new FileOutputStream(file);
	        while ((read = uploadedInputStream.read(bytes)) != -1)
	        {
	            out.write(bytes, 0, read);
	        }
	        out.flush();
	        out.close();
	        
	        
	        UploadedFile u = new UploadedFile();
	        u.setFilename(filename);
	        u.getId();
	        u = repo.save(u);
	        
	        Student s = studentRepo.findById(id);
	        s.getName();
	        s.getEmail();
	        s.setImageId(u.getId());
	        
	        

	        s = studentRepo.save(s);
	  
	        return "OK - save to imageID "+u.getId();
	    } catch (IOException e)
	    {
	    	e.printStackTrace();
	    	return "BAD";
	    }
	}
	
	
	// for some reason, Lazy initialization errors occur without @Transactional
	
	@Transactional
	public byte[] getImageFile(Long id) throws Exception
	{
		UploadedFile file = repo.getOne(id);
		String filename = file.getFilename();
		
    	File dir = new File(UPLOAD_PATH);
        File imagefile = new File(dir, filename);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
		InputStream is = new FileInputStream(imagefile);
		byte[] bytes = new byte[1024];
		int read = -1;
        while ((read = is.read(bytes)) != -1)
        {
            baos.write(bytes, 0, read);
        }
        baos.flush();
        is.close();
        
        return baos.toByteArray();

		
	}
}
