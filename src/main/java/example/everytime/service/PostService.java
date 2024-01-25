package example.everytime.service;

import example.everytime.domain.Member;
import example.everytime.domain.Post;
import example.everytime.dto.PostDto;
import example.everytime.exception.MemberNotFoundException;
import example.everytime.exception.PostNotFoundException;
import example.everytime.repository.MemberRepository;
import example.everytime.repository.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;
  private final MemberRepository memberRepository;

  public Long addPost(PostDto postDto) {
    Member member =
        memberRepository.findById(postDto.getMemberId()).orElseThrow(MemberNotFoundException::new);
    Post post = postRepository.save(Post.toPost(postDto, member));
    return post.getPostId();
  }

  public List<PostDto> getAllPosts() {
    List<Post> posts = postRepository.findAllWithMember();
    return posts.stream().map(PostDto::from).toList();
  }

  public PostDto getPost(Long postId) {
    Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
    return PostDto.from(post);
  }

  public void deletePost(Long postId) {
    postRepository.deleteById(postId);
  }
}
