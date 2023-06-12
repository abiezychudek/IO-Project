package com.example.recipeswebsite.services;

import com.example.recipeswebsite.model.Comment;
import com.example.recipeswebsite.model.Post;
import com.example.recipeswebsite.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import java.util.Optional;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostFactoryTest {
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostFactory postService;

    @Test
    public void testSave_NewPost() {
        // Creating a new post with null ID
        Post post = new Post();
        post.setTitle("New Post");

        // Mocking the postRepository behavior
        when(postRepository.save(post)).thenReturn(post);

        // Calling the service method
        Post savedPost = postService.save(post);

        // Verifying that the post's createdAt field is set
        assertThat(savedPost.getCreatedAt()).isNotNull();

        // Verifying that the postRepository save method was called
        verify(postRepository).save(post);
    }

    @Test
    public void testSave_ExistingPost() {
        // given
        Long postId = 1L;
        Post post = new Post();
        post.setId(postId);
        post.setTitle("Existing Post");

        // when
        when(postRepository.save(post)).thenReturn(post);

        // then
        Post savedPost = postService.save(post);

        // Verifying that the post's createdAt field is not modified
        assertThat(savedPost.getCreatedAt()).isNull();

        // Verifying that the postRepository save method was called
        verify(postRepository).save(post);
    }

    @Test
    public void testSaveAll() {
        // given
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post();
        post1.setTitle("Post 1");
        posts.add(post1);

        Post post2 = new Post();
        post2.setTitle("Post 2");
        posts.add(post2);
        //when
        postService.saveAll(posts);
        //then
        verify(postRepository).saveAll(posts);
    }

    @Test
    public void testGetById_PostDoesNotExist() {
        //given
        Long postId = 1L;
        when(postRepository.findById(postId)).thenReturn(Optional.empty());

        // when
        Optional<Post> result = postService.getById(postId);

        // then
        verify(postRepository).findById(postId);
        assertThat(result).isEmpty();
    }

    @Test
    public void testGetById_PostExists() {
        //given
        Long postId = 1L;
        Post post = new Post();
        post.setId(postId);
        post.setTitle("Test Post");

        //when
        when(postRepository.findById(postId)).thenReturn(Optional.of(post));

        Optional<Post> result = postService.getById(postId);

        //then
        verify(postRepository).findById(postId);


        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(postId);
        assertThat(result.get().getTitle()).isEqualTo("Test Post");
    }


    @Test
    public void testAddRatingToPost() {
        // Create a mock post with id 1, average rating 4.0 and number of ratings 2
        Post mockPost = new Post();
        mockPost.setId(1L);
        mockPost.setAvgRating(4.0);
        mockPost.setNumOfRatings(2);

        // Create a mock list of accepted posts and add the mock post to it
        List<Post> mockAcceptedPosts = new ArrayList<>();
        mockAcceptedPosts.add(mockPost);

        // Create a mock service and inject the mock list of accepted posts
        postService.saveAccepted(mockPost);

        // Call the method under test with id 1 and rating 5.0
        postService.addRatingToPost(1L, 5.0);

        // Verify that the average rating and number of ratings of the post are updated correctly
        assertEquals(4.333333333333333, mockPost.getAvgRating(), 0.00001); // The new average rating should be (4*2 + 5) / 3
        assertEquals(3, mockPost.getNumOfRatings()); // The new number of ratings should be 2 + 1
    }
}