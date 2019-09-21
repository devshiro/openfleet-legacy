package com.github.devshiro.openfleet.webapp.view;

import com.github.devshiro.openfleet.api.model.Location;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import java.util.List;

@Route("")
@PWA(name = "Openfleet 2 Fleet management application", shortName = "Openfleet2")
public class MainView extends VerticalLayout {

    public MainView() {
        Grid<Location> locationGrid = new Grid<>(Location.class);
        List<Location> locations = List.of(
                Location.builder()
                        .id(1L)
                        .city("Budapest")
                        .country("Hungary")
                        .houseNo("01")
                        .region("Pest")
                        .street("Sample street")
                        .zipcode("1087")
                        .build()
        );
        locationGrid.setItems(locations);
        add(locationGrid);
        setSizeFull();
    }

}
