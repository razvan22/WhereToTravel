package com.whertotravel.entities.destination.model;

import com.whertotravel.entities.comment.model.Comment;
import com.whertotravel.entities.dislike.model.Dislike;
import com.whertotravel.entities.image.model.Image;
import com.whertotravel.entities.like.model.Like;
import com.whertotravel.entities.location.model.Location;
import com.whertotravel.entities.user.model.User;
import jakarta.persistence.Id;

import java.util.List;

//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
public class Destination {
  @Id
  private String id;
  private User author;
  private String title;
  private String description;
  private Location location;
  private List<Like> likes;
  private List<Dislike> dislikes;
  private List<Comment> comments;
  private List<Image> images;
}
