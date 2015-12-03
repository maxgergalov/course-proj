package by.gergalov.max.course.repository;

import by.gergalov.max.course.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImageRepository extends JpaRepository<Image,Long> {
}
