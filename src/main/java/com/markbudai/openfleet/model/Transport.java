package com.markbudai.openfleet.model;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.transaction.TransactionalException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Set<TransferCost> costs;


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

    public Location getPlace_of_load() {
        return place_of_load;
    }

    public void setPlace_of_load(Location place_of_load) {
        this.place_of_load = place_of_load;
    }

    public LocalDateTime getTime_of_load() {
        return time_of_load;
    }

    public void setTime_of_load(LocalDateTime time_of_load) {
        this.time_of_load = time_of_load;
    }

    public String getCargo_name() {
        return cargo_name;
    }

    public void setCargo_name(String cargo_name) {
        this.cargo_name = cargo_name;
    }

    public long getCargo_weight() {
        return cargo_weight;
    }

    public void setCargo_weight(long cargo_weight) {
        this.cargo_weight = cargo_weight;
    }

    public long getCargo_count() {
        return cargo_count;
    }

    public void setCargo_count(long cargo_count) {
        this.cargo_count = cargo_count;
    }

    public Location getPlace_of_unload() {
        return place_of_unload;
    }

    public void setPlace_of_unload(Location place_of_unload) {
        this.place_of_unload = place_of_unload;
    }

    public LocalDateTime getTime_of_unload() {
        return time_of_unload;
    }

    public void setTime_of_unload(LocalDateTime time_of_unload) {
        this.time_of_unload = time_of_unload;
    }

    public Set<TransferCost> getCosts() {
        return costs;
    }

    public void setCosts(Set<TransferCost> costs) {
        this.costs = costs;
    }

    //TODO: Implement addCost(TransferCost cost) method.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transport)) return false;

        Transport transport = (Transport) o;

        if (getCargo_weight() != transport.getCargo_weight()) return false;
        if (getCargo_count() != transport.getCargo_count()) return false;
        if (getTractor() != null ? !getTractor().equals(transport.getTractor()) : transport.getTractor() != null)
            return false;
        if (getTrailer() != null ? !getTrailer().equals(transport.getTrailer()) : transport.getTrailer() != null)
            return false;
        if (getEmployee() != null ? !getEmployee().equals(transport.getEmployee()) : transport.getEmployee() != null)
            return false;
        if (getStart() != null ? !getStart().equals(transport.getStart()) : transport.getStart() != null) return false;
        if (getFinish() != null ? !getFinish().equals(transport.getFinish()) : transport.getFinish() != null)
            return false;
        if (getPlace_of_load() != null ? !getPlace_of_load().equals(transport.getPlace_of_load()) : transport.getPlace_of_load() != null)
            return false;
        if (getTime_of_load() != null ? !getTime_of_load().equals(transport.getTime_of_load()) : transport.getTime_of_load() != null)
            return false;
        if (getCargo_name() != null ? !getCargo_name().equals(transport.getCargo_name()) : transport.getCargo_name() != null)
            return false;
        if (getPlace_of_unload() != null ? !getPlace_of_unload().equals(transport.getPlace_of_unload()) : transport.getPlace_of_unload() != null)
            return false;
        return getTime_of_unload() != null ? getTime_of_unload().equals(transport.getTime_of_unload()) : transport.getTime_of_unload() == null;
    }

    @Override
    public int hashCode() {
        int result = getTractor() != null ? getTractor().hashCode() : 0;
        result = 31 * result + (getTrailer() != null ? getTrailer().hashCode() : 0);
        result = 31 * result + (getEmployee() != null ? getEmployee().hashCode() : 0);
        result = 31 * result + (getStart() != null ? getStart().hashCode() : 0);
        result = 31 * result + (getFinish() != null ? getFinish().hashCode() : 0);
        result = 31 * result + (getPlace_of_load() != null ? getPlace_of_load().hashCode() : 0);
        result = 31 * result + (getTime_of_load() != null ? getTime_of_load().hashCode() : 0);
        result = 31 * result + (getCargo_name() != null ? getCargo_name().hashCode() : 0);
        result = 31 * result + (int) (getCargo_weight() ^ (getCargo_weight() >>> 32));
        result = 31 * result + (int) (getCargo_count() ^ (getCargo_count() >>> 32));
        result = 31 * result + (getPlace_of_unload() != null ? getPlace_of_unload().hashCode() : 0);
        result = 31 * result + (getTime_of_unload() != null ? getTime_of_unload().hashCode() : 0);
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
}