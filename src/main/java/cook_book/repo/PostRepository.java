package cook_book.repo;

import cook_book.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository <Post, Long > {
}
