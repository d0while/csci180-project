package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.UploadedFile;

@Repository
public interface UploadedFileRepository extends JpaRepository<UploadedFile, Long>
{

}
