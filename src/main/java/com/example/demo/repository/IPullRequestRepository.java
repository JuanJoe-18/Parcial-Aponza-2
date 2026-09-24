package com.example.demo.repository;

import com.example.demo.model.PullRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPullRequestRepository extends JpaRepository<PullRequest, Long> {


    List<PullRequest> findDistinctByRepository_Assignment_Classroom_NameAndStatus_OrderByCreatedAtDesc(String classroomName, String status);


    /*
    * Obtener los Pull Requests donde el revisor pertenezca a un rol específico (e.g. 'TA' o
'TEACHER'),
*  el autor del PR tenga un nombre de usuario (username) dado,
*  y
pertenezcan a un Classroom de un semestre específico.
*
Si su entrada es "TA", "cjimenez" y "2026-02", su salida será: Entrega Taller JPA -
Camila Jimenez, Correcciones finales JPA - Camila Jimenez. τ*/


    //"TA", "cjimenez" y "2026-02"

    List<PullRequest> findDistinctByReviewer_Role_AndReviewer_UsernameAndRepository_Assignment_Classroom_Semester(String role, String username, String semester);


}
