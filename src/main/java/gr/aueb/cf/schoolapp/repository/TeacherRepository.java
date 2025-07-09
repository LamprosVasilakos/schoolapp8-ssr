package gr.aueb.cf.schoolapp.repository;

import gr.aueb.cf.schoolapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findByRegionId(Long id);
    Optional<Teacher> findByUuid(String uuid);
    Optional<Teacher> findByAfm(String afk);

    @Query("SELECT count(*) FROM Teacher t WHERE t.uuid = ?1")
    long getCount(String uuid);
}
