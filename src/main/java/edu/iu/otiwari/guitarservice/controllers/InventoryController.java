package edu.iu.otiwari.guitarservice.controllers;

import edu.iu.otiwari.guitarservice.model.GuitarData;
import edu.iu.otiwari.guitarservice.repository.InventoryFileRepository;
import edu.iu.otiwari.guitarservice.repository.InventoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/inventory")
public class InventoryController {

    private InventoryFileRepository inventoryFileRepository;

    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryFileRepository = inventoryFileRepository;
    }


    @GetMapping
    public List<GuitarData> findAll() {
        try {
            return inventoryFileRepository.findAll();
        } catch (IOException e) {
            return null;
        }
    }


    @PostMapping
    public boolean add(@RequestBody GuitarData data) {
        try {
            System.out.println("Adding guitar to inventory: " + data.getSerialNumber());
            return inventoryFileRepository.add(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity<GuitarData> find(@PathVariable String serialNumber) {
        try {
            GuitarData guitar = inventoryFileRepository.find(serialNumber);
            if (guitar != null) {
                return ResponseEntity
                        .status(HttpStatus.FOUND)
                        .body(guitar);
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(null);
            }
        } catch (IOException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
