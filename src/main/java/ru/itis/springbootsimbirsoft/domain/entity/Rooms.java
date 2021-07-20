package ru.itis.springbootsimbirsoft.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootsimbirsoft.domain.enums.StateType;

import javax.persistence.*;
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
    private Set<Messages> message;
}
