package ru.itis.springbootsimbirsoft.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootsimbirsoft.domain.enums.StateType;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class  Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private StateType stateType;

    @Transient
    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER)
    private List<Messages> message;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Accounts creator;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "accounts_rooms",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id"))
    private List<Accounts> users;
}
