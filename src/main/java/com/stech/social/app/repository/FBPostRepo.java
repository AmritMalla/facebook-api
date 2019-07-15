package com.stech.social.app.repository;

import com.stech.social.app.facebook.model.FB_Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FBPostRepo extends JpaRepository<FB_Post, Long> {





}
