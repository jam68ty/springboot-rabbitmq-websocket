package com.example.websocketrabbitmqdemo.dao.repositroy;

import com.example.websocketrabbitmqdemo.dao.entity.DialogueEntity;
import com.example.websocketrabbitmqdemo.dto.response.DialogueResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DialogueRepository extends JpaRepository<DialogueEntity, String>,
        JpaSpecificationExecutor<DialogueEntity> {

    @Query(
            "SELECT d FROM DialogueEntity d "
                    + "WHERE d.dialogueId = :dialogueId "
    )
    Optional<DialogueEntity> findByDialogueId(String dialogueId);

    @Query(
            "SELECT d FROM DialogueEntity d "
    )
    Optional<Page<DialogueEntity>> findAllDialogue(Pageable page);
}
