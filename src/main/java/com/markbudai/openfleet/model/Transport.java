package com.markbudai.openfleet.model;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mark on 2017. 04. 14..
 */
public class Transport {
    private long id;
    private Vehicle vehicle;
    private Driver driver;
    private LocalDateTime start;
    private LocalDateTime finish;
    private Location place_of_load;
    private LocalDateTime time_of_load;
    private String cargo_name;
    private long cargo_weight;
    private long cargo_count;
    private Location place_of_unload;
    private LocalDateTime time_of_unload;
    private List<TransferCost> costs;
}