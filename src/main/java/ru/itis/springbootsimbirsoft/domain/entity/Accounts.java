package ru.itis.springbootsimbirsoft.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootsimbirsoft.domain.enums.StateActive;
import ru.itis.springbootsimbirsoft.domain.enums.StateConfirmed;
import ru.itis.springbootsimbirsoft.domain.enums.StateRole;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class  Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private StateActive stateActive;

    @Enumerated(value = EnumType.STRING)
    private StateConfirmed stateConfirmed;

    @Enumerated(value = EnumType.STRING)
    private StateRole role;

    private String phone;

    private String confirmCode;

    public boolean isActive() {
        return this.stateActive == StateActive.ACTIVE;
    }

    public boolean isBanned() {
        return this.stateActive == StateActive.BANNED;
    }

    public boolean isAdmin() {
        return this.role == StateRole.ADMIN;
    }

    @Transient
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Messages> message;
}
