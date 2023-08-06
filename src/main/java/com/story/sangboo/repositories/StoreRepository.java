package com.story.sangboo.repositories;

import com.story.sangboo.entities.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store,Long> {

    @Query("SELECT s FROM Store s ORDER BY id DESC")
    Page<Store> findAllByPage(Pageable pageable);

    @Query("SELECT s FROM Store s WHERE s.user.id = :userId ORDER BY s.id DESC")
    List<Store> findAllByUserId(@Param("userId") Long userId);

    @Query("SELECT s FROM Store s " +
            "WHERE s.id IN (" +
            "   SELECT st.store.id " +
            "   FROM Story st " +
            "   WHERE st.emotion = :emotion " +
            "   GROUP BY st.store.id " +
            "   HAVING COUNT(st.emotion) >= ALL (" +
            "       SELECT COUNT(st1.emotion) " +
            "       FROM Story st1 " +
            "       WHERE st1.store = st.store " +
            "       GROUP BY st1.emotion" +
            "   )" +
            ")")
    List<Store> findByMaxEmotion(@Param("emotion") String emotion);
}
