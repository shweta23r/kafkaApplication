package net.javaguides.springboot.consumer.repository;

import net.javaguides.springboot.consumer.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiMediaChangesRepository extends JpaRepository<WikimediaData,Long> {

}
