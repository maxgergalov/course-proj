package by.gergalov.max.course.service.tag;

import by.gergalov.max.course.entity.Tag;
import by.gergalov.max.course.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TagServiceImpl implements TagService {
    @Autowired
    TagRepository tagRepository;


    @Override
    public long count() {
        return tagRepository.count();
    }

    @Override
    public Tag getById(long id) {
        return tagRepository.findOne(id);
    }
}
