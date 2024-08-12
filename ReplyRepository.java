import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    // Method to find all active replies for a specific post
    List<Reply> findByPostAndStatus(Post post, Status status);

    // Alternatively, using a custom JPQL query
    @Query("SELECT r FROM Reply r WHERE r.post = :post AND r.status = :status")
    List<Reply> findActiveRepliesForPost(@Param("post") Post post, @Param("status") Status status);

    // Method to find all replies for a specific post
    List<Reply> findByPost(Post post);
}
