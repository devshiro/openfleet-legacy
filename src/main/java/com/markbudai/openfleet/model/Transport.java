package com.markbudai.openfleet.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mark on 2017. 04. 14..
 */
@Entity
@Table(name = "transport")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Tractor tractor;
    @ManyToOne
    private Trailer trailer;
    @ManyToOne
    private Employee employee;
    private LocalDateTime start;
    private LocalDateTime finish;
    @ManyToOne
    private Location place_of_load;
    private LocalDateTime time_of_load;
    private String cargo_name;
    private long cargo_weight;
    private long cargo_count;
    @ManyToOne
    private Location place_of_unload;
    private LocalDateTime time_of_unload;
    @OneToMany(cascade = CascadeType.ALL,targetEntity = TransferCost.class)
    private List<TransferCost> costs;


    public Transport() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Tractor getTractor() {
        return tractor;
    }

    public void setTractor(Tractor tractor) {
        this.tractor = tractor;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public Location getPlaceOfLoad() {
        return place_of_load;
    }

    public void setPlaceOfLoad(Location place_of_load) {
        this.place_of_load = place_of_load;
    }

    public LocalDateTime getTimeOfLoad() {
        return time_of_load;
    }

    public void setTimeOfLoad(LocalDateTime time_of_load) {
        this.time_of_load = time_of_load;
    }

    public String getCargoName() {
        return cargo_name;
    }

    public void setCargoName(String cargo_name) {
        this.cargo_name = cargo_name;
    }

    public long getCargoWeight() {
        return cargo_weight;
    }

    public void setCargoWeight(long cargo_weight) {
        this.cargo_weight = cargo_weight;
    }

    public long getCargoCount() {
        return cargo_count;
    }

    public void setCargoCount(long cargo_count) {
        this.cargo_count = cargo_count;
    }

    public Location getPlaceOfUnload() {
        return place_of_unload;
    }

    public void setPlaceOfUnload(Location place_of_unload) {
        this.place_of_unload = place_of_unload;
    }

    public LocalDateTime getTimeOfUnload() {
        return time_of_unload;
    }

    public void setTimeOfUnload(LocalDateTime time_of_unload) {
        this.time_of_unload = time_of_unload;
    }

    public List<TransferCost> getCosts() {
        return costs;
    }

    public void setCosts(List<TransferCost> costs) {
        this.costs = costs;
    }


    public void addCost(TransferCost cost){
        this.costs.add(cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transport)) return false;

        Transport transport = (Transport) o;

        if (getCargoWeight() != transport.getCargoWeight()) return false;
        if (getCargoCount() != transport.getCargoCount()) return false;
        if (getTractor() != null ? !getTractor().equals(transport.getTractor()) : transport.getTractor() != null)
            return false;
        if (getTrailer() != null ? !getTrailer().equals(transport.getTrailer()) : transport.getTrailer() != null)
            return false;
        if (getEmployee() != null ? !getEmployee().equals(transport.getEmployee()) : transport.getEmployee() != null)
            return false;
        if (getStart() != null ? !getStart().equals(transport.getStart()) : transport.getStart() != null) return false;
        if (getFinish() != null ? !getFinish().equals(transport.getFinish()) : transport.getFinish() != null)
            return false;
        if (getPlaceOfLoad() != null ? !getPlaceOfLoad().equals(transport.getPlaceOfLoad()) : transport.getPlaceOfLoad() != null)
            return false;
        if (getTimeOfLoad() != null ? !getTimeOfLoad().equals(transport.getTimeOfLoad()) : transport.getTimeOfLoad() != null)
            return false;
        if (getCargoName() != null ? !getCargoName().equals(transport.getCargoName()) : transport.getCargoName() != null)
            return false;
        if (getPlaceOfUnload() != null ? !getPlaceOfUnload().equals(transport.getPlaceOfUnload()) : transport.getPlaceOfUnload() != null)
            return false;
        return getTimeOfUnload() != null ? getTimeOfUnload().equals(transport.getTimeOfUnload()) : transport.getTimeOfUnload() == null;
    }

    @Override
    public int hashCode() {
        int result = getTractor() != null ? getTractor().hashCode() : 0;
        result = 31 * result + (getTrailer() != null ? getTrailer().hashCode() : 0);
        result = 31 * result + (getEmployee() != null ? getEmployee().hashCode() : 0);
        result = 31 * result + (getStart() != null ? getStart().hashCode() : 0);
        result = 31 * result + (getFinish() != null ? getFinish().hashCode() : 0);
        result = 31 * result + (getPlaceOfLoad() != null ? getPlaceOfLoad().hashCode() : 0);
        result = 31 * result + (getTimeOfLoad() != null ? getTimeOfLoad().hashCode() : 0);
        result = 31 * result + (getCargoName() != null ? getCargoName().hashCode() : 0);
        result = 31 * result + (int) (getCargoWeight() ^ (getCargoWeight() >>> 32));
        result = 31 * result + (int) (getCargoCount() ^ (getCargoCount() >>> 32));
        result = 31 * result + (getPlaceOfUnload() != null ? getPlaceOfUnload().hashCode() : 0);
        result = 31 * result + (getTimeOfUnload() != null ? getTimeOfUnload().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", tractor=" + tractor +
                ", trailer=" + trailer +
                ", employee=" + employee +
                ", start=" + start +
                ", finish=" + finish +
                ", place_of_load=" + place_of_load +
                ", time_of_load=" + time_of_load +
                ", cargo_name='" + cargo_name + '\'' +
                ", cargo_weight=" + cargo_weight +
                ", cargo_count=" + cargo_count +
                ", place_of_unload=" + place_of_unload +
                ", time_of_unload=" + time_of_unload +
                ", costs=" + costs +
                '}';
    }

    public static List<Transport> filter(int year, List<Transport> transports){
        return transports.stream().filter(p->p.getFinish().getYear() == year).collect(Collectors.toList());
    }

    public static List<Transport> filter(int year, int month, List<Transport> transports){
        return transports.stream().filter(p->p.getFinish().getYear() == year)
                .filter(p->p.getFinish().getMonth().getValue() == month)
                .collect(Collectors.toList());
    }

    public static List<Transport> filter(int year, int month, int dayOfMonth, List<Transport> transports){
        return transports.stream().filter(p->p.getFinish().getYear() == year)
                .filter(p->p.getFinish().getMonth().getValue() == month)
                .filter(p->p.getFinish().getDayOfMonth() == dayOfMonth)
                .collect(Collectors.toList());
    }

    public static List<Transport> filter(LocalDate date, List<Transport> transports){
        return transports.stream().filter(p->p.getFinish().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

}