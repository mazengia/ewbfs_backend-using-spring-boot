package com.example.ewbfsbackend.Status;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/status")
public class StatusController implements StatusAPI {

    StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }


    @Override
    public StatusDTO updateStatus(long id, Status status) {
        return statusService.updateStatus(id, status);
    }

    @Override
    public ResponseEntity<StatusDTO> findStatusById(Long id) {
        StatusDTO statusDTO = statusService.findStatusById(id);
        if (statusDTO != null) return ResponseEntity.ok(statusDTO);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<StatusDTO> deleteStatus(Long id) {
        StatusDTO statusDTO = statusService.deleteCustomersById(id);
        if (statusDTO != null) return ResponseEntity.ok(statusDTO);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<CollectionModel<StatusDTO>> findAll(Integer page, Integer size) {
        {
            CollectionModel<StatusDTO> statusDTOS = statusService.findAll(page, size);
            if (statusDTOS != null)
                return ResponseEntity.ok(statusDTOS);
            return ResponseEntity.noContent().build();
        }
    }


    @Override
    public StatusDTO addStatus(Status status) {
        return statusService.addStatus(status);
    }
}
