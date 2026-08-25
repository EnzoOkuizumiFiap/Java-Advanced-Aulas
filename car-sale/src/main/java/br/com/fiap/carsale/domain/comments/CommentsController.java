package br.com.fiap.carsale.domain.comments;

import br.com.fiap.carsale.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentsController {
    private final CommentService commentService;
    private final UserRepository userRepository;

    @GetMapping
    public List<CommentResponse> getAllComments() {
        return commentService.getAllComments().stream().map(CommentResponse::fromModel).toList();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')") // E ESSA LINHA TAMBÉM
    public Comment createComment(@RequestBody CommentRequest commentRequest) {
        return commentService.createComment(commentRequest.toModel());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')") // E ESSA LINHA TAMBÉM
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

}
