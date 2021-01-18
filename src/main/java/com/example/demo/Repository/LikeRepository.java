package com.example.demo.Repository;

import com.example.demo.Entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Integer> {
//    1) Просмотр всех кто user кто поставил лайк
//    2) Поиск user по лайку
}
