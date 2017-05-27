package com.markbudai.openfleet.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class representing a transport job.
 *
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

    /**
     * Empty constructor for creating {@link com.markbudai.openfleet.model.Transport} object.
     */
    public Transport() {
    }

    /**
     * Gets the {@code id} of the {@link com.markbudai.openfleet.model.Transport} object.
     * @return the {@code id} of the {@link com.markbudai.openfleet.model.Transport} object.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the {@code id} of the {@link com.markbudai.openfleet.model.Transport} object.
     * @param id the {@code id} of the {@link com.markbudai.openfleet.model.Transport} object.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the {@link com.markbudai.openfleet.model.Tractor} used in the transport.
     * @return the {@link com.markbudai.openfleet.model.Tractor} used in the transport.
     */
    public Tractor getTractor() {
        return tractor;
    }

    /**
     * Sets the {@link com.markbudai.openfleet.model.Tractor} used in the transport.
     * @param tractor the {@link com.markbudai.openfleet.model.Tractor} used in the transport.
     */
    public void setTractor(Tractor tractor) {
        this.tractor = tractor;
    }

    /**
     * Gets the {@link com.markbudai.openfleet.model.Trailer} used in the transport.
     * @return the {@link com.markbudai.openfleet.model.Trailer} used in the transport.
     */
    public Trailer getTrailer() {
        return trailer;
    }

    /**
     * Sets the {@link com.markbudai.openfleet.model.Trailer} used in the transport.
     * @param trailer the {@link com.markbudai.openfleet.model.Trailer} used in the transport.
     */
    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    /**
     * Gets the {@link com.markbudai.openfleet.model.Employee} who did the transport.
     * @return the {@link com.markbudai.openfleet.model.Employee} who did the transport.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets the {@link com.markbudai.openfleet.model.Employee} who did the transport.
     * @param employee the {@link com.markbudai.openfleet.model.Employee} who did the transport.
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Gets the {@link java.time.LocalDateTime} when the employee started the transport.
     * @see Transport#setStart(LocalDateTime)
     * @return the {@link java.time.LocalDateTime} when the employee started the transport.
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     * Sets the {@link java.time.LocalDateTime} when the employee started the transport.
     * <p>Usually the transport job starts when the employee gets the details about the transport
     * he/she has to do next and starts driving towards the place of load.</p>
     * @param start the {@link java.time.LocalDateTime} when the employee started the transport.
     */
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    /**
     * Gets the {@link java.time.LocalDateTime} when the employee finished the transport.
     * @see Transport#setFinish(LocalDateTime)
     * @return the {@link java.time.LocalDateTime} when the employee finished the transport.
     */
    public LocalDateTime getFinish() {
        return finish;
    }

    /**
     * Sets the {@link java.time.LocalDateTime} when the employee finished the transport.
     * <p>Usually the transport job finished when the driver unloaded the cargo. But there
     * could be cases when a final assembly is also the driver's responsibility. In these cases
     * the finish time is when the driver completed all the assmeblies and post-transport tasks.</p>
     * @param finish the {@link java.time.LocalDateTime} when the employee finished the transport.
     */
    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    /**
     * Gets the {@link com.markbudai.openfleet.model.Location} where the cargo has to be loaded.
     * @return the {@link com.markbudai.openfleet.model.Location} where the cargo has to be loaded.
     */
    public Location getPlaceOfLoad() {
        return place_of_load;
    }

    /**
     * Sets the {@link com.markbudai.openfleet.model.Location} where the cargo has to be loaded.
     * @param place_of_load the {@link com.markbudai.openfleet.model.Location} where the cargo has to be loaded.
     */
    public void setPlaceOfLoad(Location place_of_load) {
        this.place_of_load = place_of_load;
    }

    /**
     * Gets the {@link java.time.LocalDateTime} when the cargo was loaded.
     * @return the {@link java.time.LocalDateTime} when the cargo was loaded.
     */
    public LocalDateTime getTimeOfLoad() {
        return time_of_load;
    }

    /**
     * Sets the {@link java.time.LocalDateTime} when the cargo was loaded.
     * @param time_of_load the {@link java.time.LocalDateTime} when the cargo was loaded.
     */
    public void setTimeOfLoad(LocalDateTime time_of_load) {
        this.time_of_load = time_of_load;
    }

    /**
     * Gets the name of the cargo.
     * @see Transport#setCargoName(String)
     * @return the name of the cargo.
     */
    public String getCargoName() {
        return cargo_name;
    }

    /**
     * Sets the name of the cargo.
     * <p>The name is a short description, or exact product name.</p>
     * <p>For example: "2016 Audi A6 Avant Quattro S-Line" or "Steel beams".</p>
     * @param cargo_name the name of the cargo.
     */
    public void setCargoName(String cargo_name) {
        this.cargo_name = cargo_name;
    }

    /**
     * Gets the weight of the cargo.
     * @see Transport#setCargoWeight(long)
     * @return the weight of the cargo.
     */
    public long getCargoWeight() {
        return cargo_weight;
    }

    /**
     * Sets the weight of the cargo.
     * <p>Altough there is no restrictions in using any type of units, it is highly advised to use metric system's kg.</p>
     * @param cargo_weight the weight of the cargo.
     */
    public void setCargoWeight(long cargo_weight) {
        this.cargo_weight = cargo_weight;
    }

    /**
     * Gets the cargo count.
     * @see Transport#setCargoCount(long)
     * @return the cargo count.
     */
    public long getCargoCount() {
        return cargo_count;
    }

    /**
     * Sets the caro count.
     * <p>It could be per piece count or pallet count.</p>
     * @param cargo_count the cargo count.
     */
    public void setCargoCount(long cargo_count) {
        this.cargo_count = cargo_count;
    }

    /**
     * Gets the {@link com.markbudai.openfleet.model.Location} of the cargo load.
     * @return the {@link com.markbudai.openfleet.model.Location} of the cargo load.
     */
    public Location getPlaceOfUnload() {
        return place_of_unload;
    }

    /**
     * Sets the {@link com.markbudai.openfleet.model.Location} of the cargo load.
     * @param place_of_unload the {@link com.markbudai.openfleet.model.Location} of the cargo load.
     */
    public void setPlaceOfUnload(Location place_of_unload) {
        this.place_of_unload = place_of_unload;
    }

    /**
     * Gets the {@link java.time.LocalDateTime} when the cargo was unloaded.
     * @return the {@link java.time.LocalDateTime} when the cargo was unloaded.
     */
    public LocalDateTime getTimeOfUnload() {
        return time_of_unload;
    }

    /**
     * Sets the {@link java.time.LocalDateTime} when the cargo was unloaded.
     * @param time_of_unload the {@link java.time.LocalDateTime} when the cargo was unloaded.
     */
    public void setTimeOfUnload(LocalDateTime time_of_unload) {
        this.time_of_unload = time_of_unload;
    }

    /**
     * Gets the {@link java.util.List} of expenses in form of {@link com.markbudai.openfleet.model.TransferCost}s made during the transport.
     * @return the {@link java.util.List} of expenses in form of {@link com.markbudai.openfleet.model.TransferCost}s made during the transport.
     */
    public List<TransferCost> getCosts() {
        return costs;
    }

    /**
     * Sets the {@link java.util.List} of expenses in form of {@link com.markbudai.openfleet.model.TransferCost}s made during the transport.
     * @param costs the {@link java.util.List} of expenses in form of {@link com.markbudai.openfleet.model.TransferCost}s made during the transport.
     */
    public void setCosts(List<TransferCost> costs) {
        this.costs = costs;
    }

    /**
     * Adds a new {@link com.markbudai.openfleet.model.TransferCost} which describes and expense to the transport.
     * @param cost a {@link com.markbudai.openfleet.model.TransferCost} which describes and expense to the transport.
     */
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

    /**
     * Filters a {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport} objects by finish year.
     * @param year the year when the transports were finished.
     * @param transports the {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport} which needs to be filtered.
     * @return the filtered {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport}s.
     */
    public static List<Transport> filter(int year, List<Transport> transports){
        return transports.stream().filter(p->p.getFinish().getYear() == year).collect(Collectors.toList());
    }

    /**
     * Filters a {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport} objects by finish year and month.
     * @param year the year when the transports were finished.
     * @param month the month of the given year when the transports were finished.
     * @param transports the {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport} which needs to be filtered.
     * @return the filtered {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport}s.
     */
    public static List<Transport> filter(int year, int month, List<Transport> transports){
        return transports.stream().filter(p->p.getFinish().getYear() == year)
                .filter(p->p.getFinish().getMonth().getValue() == month)
                .collect(Collectors.toList());
    }

    /**
     * Filters a {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport} objects by finish year, month, and day.
     * @param year the year when the transports were finished.
     * @param month the month of the given year when the transports were finished.
     * @param dayOfMonth the day of the given month when the transports were finished.
     * @param transports the {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport} which needs to be filtered.
     * @return the filtered {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport}s.
     */
    public static List<Transport> filter(int year, int month, int dayOfMonth, List<Transport> transports){
        return transports.stream().filter(p->p.getFinish().getYear() == year)
                .filter(p->p.getFinish().getMonth().getValue() == month)
                .filter(p->p.getFinish().getDayOfMonth() == dayOfMonth)
                .collect(Collectors.toList());
    }

    /**
     * Filters a {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport} objects by finish {@link java.time.LocalDate}.
     * @param date the {@link java.time.LocalDate} when the transports were finished.
     * @param transports the {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport} which needs to be filtered.
     * @return the filtered {@link java.util.List} of {@link com.markbudai.openfleet.model.Transport}s.
     */
    public static List<Transport> filter(LocalDate date, List<Transport> transports){
        return transports.stream().filter(p->p.getFinish().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

}