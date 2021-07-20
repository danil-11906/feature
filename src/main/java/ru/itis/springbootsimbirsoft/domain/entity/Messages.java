package ru.itis.springbootsimbirsoft.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootsimbirsoft.domain.enums.StateActive;
import ru.itis.springbootsimbirsoft.domain.enums.StateConfirmed;
import ru.itis.springbootsimbirsoft.domain.enums.StateRole;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class  Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Accounts account;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Rooms room;

}
