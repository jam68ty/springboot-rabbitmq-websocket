package com.example.websocketrabbitmqdemo.dao.repositroy;

import com.example.websocketrabbitmqdemo.dao.entity.ChatroomEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ChatroomRepository extends JpaRepository<ChatroomEntity, String>,
        JpaSpecificationExecutor<ChatroomEntity> {

    @Query(
            "SELECT t FROM ChatroomEntity t "
                    + "WHERE t.createdUserId=:userId " +
                    "OR t.receiveUserId=:userId"
    )
    Optional<Page<ChatroomEntity>> findChatroomByIdUserId(String userId, Pageable page);

    @Transactional
    @Modifying
    @Query(
            "UPDATE ChatroomEntity " +
                    "SET latestDialogueId = :latestDialogueId, lastModifiedDate = :now "
                    + "WHERE chatroomId = :chatroomId"
    )
    void updateLatestDialogueId(String latestDialogueId, String chatroomId, LocalDateTime now);
}

