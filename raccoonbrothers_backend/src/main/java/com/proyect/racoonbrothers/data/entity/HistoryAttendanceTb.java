package com.proyect.racoonbrothers.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "history_attendances")
@ToString
public class HistoryAttendanceTb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_account")
    private Long idAccount;

    @Column(name = "entry_time")
    private Date entryTime;

    @Column(name = "departure_time")
    private Date departureTime;

}
