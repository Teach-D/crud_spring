package hello.crud_project.db.repository;

import hello.crud_project.db.BoardItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaRepository extends JpaRepository<BoardItem, Long> {
}
