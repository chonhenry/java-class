import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public List<Reply> getActiveRepliesForPost(Post post) {
        return replyRepository.findByPostAndStatus(post, Status.ACTIVE);
    }

    public List<Reply> getRepliesForPost(Post post) {
        return replyRepository.findByPost(post);
    }
}
